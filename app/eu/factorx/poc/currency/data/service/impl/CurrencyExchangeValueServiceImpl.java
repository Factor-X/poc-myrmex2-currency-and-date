package eu.factorx.poc.currency.data.service.impl;

import com.avaje.ebean.Ebean;
import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.data.boToVoConverter.CurrencyExchangeValueBoToCurrencyExchangeValueVOConverter;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.voToBoConveter.CurrencyExchangeValueVOToCurrencyExchangeValueBOConverter;
import eu.factorx.poc.currency.data.service.boInterface.CurrencyExchangeValueService;
import eu.factorx.poc.currency.data.service.voInterface.CurrencyExchangeValueVoService;
import eu.factorx.poc.currency.data.service.voInterface.PeriodVoService;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.deployement.dto.forWebService.QuandlCurrenciesDTO;
import eu.factorx.poc.currency.util.exception.MyException;
import eu.factorx.poc.currency.util.webServiceCall.HttpRequestEnum;
import eu.factorx.poc.currency.util.webServiceCall.QuandlApiRequest;
import play.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florian on 8/01/15.
 */
public class CurrencyExchangeValueServiceImpl implements CurrencyExchangeValueService,CurrencyExchangeValueVoService {

    //converter
    CurrencyExchangeValueVOToCurrencyExchangeValueBOConverter currencyExchangeValueVOToCurrencyExchangeValueBOConverter = new CurrencyExchangeValueVOToCurrencyExchangeValueBOConverter();
    CurrencyExchangeValueBoToCurrencyExchangeValueVOConverter currencyExchangeValueBoToCurrencyExchangeValueVOConverter = new CurrencyExchangeValueBoToCurrencyExchangeValueVOConverter();
    //PeriodBoToPeriodVoConverter periodBoToPeriodVoConverter = new PeriodBoToPeriodVoConverter();

    //service
    private PeriodVoService periodVoService = new PeriodServiceImpl();

    private QuandlApiRequest quandlApiRequest = new QuandlApiRequest();

    public CurrencyExchangeValueVO findByPeriod(Currency currency, PeriodVO periodVO) {

        //TODO test if value for this period can be already used. Instead, load last valid value

        Currency currency2 = Currency.CURRENCY_VO_COMPARISON_DEFAULT;

        return Ebean.createNamedQuery(CurrencyExchangeValueVO.class, CurrencyExchangeValueVO.FIND_BY_CURRENCIES_AND_PERIOD)
                .setParameter("currency1", currency.getCode())
                .setParameter("currency2", currency2.getCode())
                .setParameter("period_id", periodVO.getId())
                .findUnique();
    }

    @Override
    public CurrencyExchangeValueBO findByPeriod(Currency currency, PeriodBO periodBO) {

        //call period
        PeriodVO periodVO = periodVoService.findVoById(periodBO.getId());

        CurrencyExchangeValueVO currencyExchangeValueVO = findByPeriod(currency, periodVO);

        if (currencyExchangeValueVO == null) {
            return null;
        }

        return currencyExchangeValueVOToCurrencyExchangeValueBOConverter.convert(currencyExchangeValueVO);
    }

    public void saveOrUpdate(CurrencyExchangeValueBO currencyExchangeValueBO) {

        //convert
        saveOrUpdate(currencyExchangeValueBoToCurrencyExchangeValueVOConverter.convert(currencyExchangeValueBO));
    }

    private void saveOrUpdate(CurrencyExchangeValueVO vo) {
        if (vo.getId() == null) {
            vo.save();
        } else {
            vo.update();
        }
    }

    /**
     * refresh data for specific period
     */
    @Override
    public void loadValuesForPeriod(PeriodBO periodBO) {

        Currency currency2 = Currency.CURRENCY_VO_COMPARISON_DEFAULT;

        for (Currency currency1 : Currency.values()) {

            Logger.info("currency1:" + currency1);

            //control if the currencyEchangeRate already exists
            if (findByPeriod(currency1, periodBO) == null && currency1 != Currency.CURRENCY_VO_COMPARISON_DEFAULT) {


                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                //build params
                Map<String, String> mapParams = new HashMap<>();

                mapParams.put(QuandlApiRequest.QuandlParamsEnum.TRIM_START.getUrl_name(), dateFormat.format(periodBO.getStartDate()));
                mapParams.put(QuandlApiRequest.QuandlParamsEnum.TRIM_END.getUrl_name(), dateFormat.format(periodBO.getEndDate()));


                try {

                    String url = HttpRequestEnum.QUANDL_CURRENCY_PAIR.getUrl();

                    //build url
                    url = url.replace("{currency1}", currency1.getCode()).replace("{currency2}", currency2.getCode());
                    //{currency1}{currency2}


                    QuandlCurrenciesDTO quandlCurrenciesDTO = quandlApiRequest.sendRequest(HttpRequestEnum.QUANDL_CURRENCY_PAIR.getMethodType(), url, mapParams, QuandlCurrenciesDTO.class);

                    //compute the average
                    double total = 0.0;
                    int nbData = 0;


                    for (List<String> strings : quandlCurrenciesDTO.getData()) {
                        total += Double.parseDouble(strings.get(1));

                        nbData++;
                    }

                    double average = total / nbData;

                    CurrencyExchangeValueVO currencyExchangeValueVO = new CurrencyExchangeValueVO();

                    currencyExchangeValueVO.setCurrency1(currency1);
                    currencyExchangeValueVO.setCurrency2(currency2);
                    currencyExchangeValueVO.setPeriod(periodVoService.findVoById(periodBO.getId()));
                    currencyExchangeValueVO.setValue(average);

                    saveOrUpdate(currencyExchangeValueVO);

                    //TODO manage 429 status


                } catch (MyException e) {
                    e.printStackTrace();
                    //TODO manage technical exception
                }
            }
        }
    }


}
