package eu.factorx.poc.currency.deployement;

import com.google.common.collect.Lists;
import eu.factorx.poc.currency.business.CurrencyExchangeValueBusiness;
import eu.factorx.poc.currency.business.PeriodBusiness;
import eu.factorx.poc.currency.business.impl.CurrencyExchangeValueBusinessImpl;
import eu.factorx.poc.currency.business.impl.PeriodBusinessImpl;
import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.deployement.boToDtoConverter.PeriodBoToPeriodDTOConverter;
import eu.factorx.poc.currency.deployement.dto.PeriodDTO;
import eu.factorx.poc.currency.deployement.dto.ValueDTO;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    //business
    private PeriodBusiness periodBusiness = new PeriodBusinessImpl();
    private CurrencyExchangeValueBusiness currencyExchangeValueBusiness = new CurrencyExchangeValueBusinessImpl();
    private PeriodBoToPeriodDTOConverter periodBoToPeriodDTOConverter = new PeriodBoToPeriodDTOConverter();


    public Result refresh(Long periodId) {

        //try to load a value
        PeriodBO periodBO = periodBusiness.findById(periodId);

        //TODO control period

        currencyExchangeValueBusiness.loadValuesForPeriod(periodBO);

        return ok();//new ValueDTO(currencyExchangeValue.getValue()));
    }

    public Result getCurrencyExchange(String currency1, Long periodId) {

        //try to load a value
        PeriodBO periodBO = periodBusiness.findById(periodId);

        Currency currency = Currency.getByCode(currency1);

        //try to load exchange
        CurrencyExchangeValueBO currencyExchangeValueBO = currencyExchangeValueBusiness.findByPeriod(currency, periodBO);

        Logger.info("currencyExchangeValue:" + currencyExchangeValueBO);

        List<PeriodYearVO> periods = new ArrayList<>();

        for (PeriodBO periodYear : periodBusiness.getYearPeriod()) {
            periods.add(new PeriodYearVO(periodYear.getCode(), periodYear.getNbDay(), periodYear.getStartDate(), periodYear.getEndDate()));
        }

        return ok(new ValueDTO(currencyExchangeValueBO.getValue()));
    }

    public Result changePeriod(long periodId) {


        List<PeriodYearVO> periods = new ArrayList<>();

        List<PeriodDTO> periodDTOListDTO = new ArrayList<>();

        for (PeriodBO periodYear : periodBusiness.findAllYear()) {
            PeriodYearVO periodYear1 = new PeriodYearVO(periodYear.getCode(), periodYear.getNbDay(), periodYear.getStartDate(), periodYear.getEndDate());
            periodYear1.setId(periodYear.getId());
            periods.add(periodYear1);

            periodDTOListDTO.add(periodBoToPeriodDTOConverter.convert(periodYear));
        }

        Logger.info("periodDTOListDTO:"+periodDTOListDTO);

        //load the current period
        PeriodBO periodQuarterBO =  periodBusiness.findById(periodId);
        Logger.info(periodId+"=>"+periodQuarterBO);

        PeriodDTO currentPeriod = periodBoToPeriodDTOConverter.convert(periodQuarterBO);

        return ok(eu.factorx.poc.currency.ui.views.html.index.render(periodDTOListDTO, Lists.newArrayList(Currency.values()),currentPeriod));
    }

    public Result index() {
        PeriodQuarterBO periodQuarterBO =  periodBusiness.findQuarterByCode(periodBusiness.findYearByCode("2009"), "Q4");
        return changePeriod(periodQuarterBO.getId());
    }

}
