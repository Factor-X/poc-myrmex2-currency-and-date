package eu.factorx.poc.currency.data.boToVoConverter;

import eu.factorx.poc.currency.common.bo.CurrencyExchangeValueBO;
import eu.factorx.poc.currency.data.service.impl.PeriodServiceImpl;
import eu.factorx.poc.currency.data.service.voInterface.PeriodVoService;
import eu.factorx.poc.currency.data.vo.CurrencyExchangeValueVO;

/**
 * Created by florian on 14/01/15.
 */
public class CurrencyExchangeValueBoToCurrencyExchangeValueVOConverter implements BoConverter<CurrencyExchangeValueBO,CurrencyExchangeValueVO> {

    //service
    private PeriodVoService periodVOService = new PeriodServiceImpl();


    @Override
    public CurrencyExchangeValueVO convert(CurrencyExchangeValueBO bo) {
        CurrencyExchangeValueVO vo  =new CurrencyExchangeValueVO();

        vo.setId(bo.getId());
        vo.setCurrency1(bo.getCurrency1());
        vo.setCurrency2(bo.getCurrency2());
        vo.setPeriod(periodVOService.findVoById(bo.getPeriod().getId()));
        vo.setValue(bo.getValue());

        return vo;
    }
}
