package eu.factorx.poc.currency.data.service.boInterface;

import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.util.exception.MyException;

/**
 * Created by florian on 8/01/15.
 */
public interface CurrencyExchangeValueService {

    CurrencyExchangeValueBO findByPeriod(Currency currency, PeriodBO periodBO) throws MyException;

    void loadValuesForPeriod(PeriodBO periodBO);
}
