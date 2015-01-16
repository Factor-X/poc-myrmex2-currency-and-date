package eu.factorx.poc.currency.data.service.voInterface;

import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.util.exception.MyException;

/**
 * Created by florian on 8/01/15.
 */
public interface CurrencyExchangeValueVoService {

    CurrencyExchangeValueVO findByPeriod(Currency currency, PeriodVO periodVO) throws MyException;
}
