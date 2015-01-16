package eu.factorx.poc.currency.business;

import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;

/**
 * Created by florian on 14/01/15.
 */
public interface CurrencyExchangeValueBusiness {
    void loadValuesForPeriod(PeriodBO periodBO);

    CurrencyExchangeValueBO findByPeriod(Currency currency, PeriodBO periodBO);
}
