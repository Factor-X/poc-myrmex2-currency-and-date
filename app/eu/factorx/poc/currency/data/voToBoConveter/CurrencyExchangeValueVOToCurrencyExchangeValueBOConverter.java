package eu.factorx.poc.currency.data.voToBoConveter;

import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;

/**
 * Created by florian on 14/01/15.
 */
public class CurrencyExchangeValueVOToCurrencyExchangeValueBOConverter implements VoConverter<CurrencyExchangeValueVO,CurrencyExchangeValueBO>{

    //converter
    private PeriodVoToPeriodBoConverter periodVoToPeriodBoConverter = new PeriodVoToPeriodBoConverter();


    public CurrencyExchangeValueBO convert(CurrencyExchangeValueVO vo){
        CurrencyExchangeValueBO bo  =new CurrencyExchangeValueBO();

        bo.setId(vo.getId());
        bo.setCurrency1(vo.getCurrency1());
        bo.setCurrency2(vo.getCurrency2());
        bo.setPeriod(periodVoToPeriodBoConverter.convert(vo.getPeriod()));
        bo.setValue(vo.getValue());

        return bo;
    }
}
