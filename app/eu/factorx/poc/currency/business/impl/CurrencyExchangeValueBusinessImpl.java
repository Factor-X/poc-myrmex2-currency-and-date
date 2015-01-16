package eu.factorx.poc.currency.business.impl;

import eu.factorx.poc.currency.business.CurrencyExchangeValueBusiness;
import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.service.boInterface.CurrencyExchangeValueService;
import eu.factorx.poc.currency.data.service.impl.CurrencyExchangeValueServiceImpl;
import eu.factorx.poc.currency.util.exception.MyException;

/**
 * Created by florian on 14/01/15.
 */
public class CurrencyExchangeValueBusinessImpl implements CurrencyExchangeValueBusiness {

    //service
    private CurrencyExchangeValueService currencyExchangeValueService = new CurrencyExchangeValueServiceImpl();

    @Override
    public void loadValuesForPeriod(PeriodBO periodBO) {
        currencyExchangeValueService.loadValuesForPeriod(periodBO);
    }

    @Override
    public CurrencyExchangeValueBO findByPeriod(Currency currency, PeriodBO periodBO) {
        try {
            return  currencyExchangeValueService.findByPeriod(currency,periodBO);
        } catch (MyException e) {
            e.printStackTrace();
            return null;
        }
    }
}
