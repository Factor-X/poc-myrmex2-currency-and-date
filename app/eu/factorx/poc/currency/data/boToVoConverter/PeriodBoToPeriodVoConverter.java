package eu.factorx.poc.currency.data.boToVoConverter;

import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodBoToPeriodVoConverter implements BoConverter<PeriodBO,PeriodVO> {

    public PeriodVO convert(PeriodBO bo){

        PeriodVO vo;

        if(bo instanceof PeriodYearBO){
            vo = new PeriodYearVO();
        }
        else if(bo instanceof PeriodQuarterBO){
            vo = new PeriodQuarterVO();
        }
        else{
            vo = new PeriodMonthVO();
        }

        vo.setId(bo.getId());
        vo.setCode(bo.getCode());
        vo.setStartDate(bo.getStartDate());
        vo.setEndDate(bo.getEndDate());
        vo.setNbDay(bo.getNbDay());

        return vo;
    }
}
