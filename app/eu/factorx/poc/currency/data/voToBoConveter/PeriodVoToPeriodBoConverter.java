package eu.factorx.poc.currency.data.voToBoConveter;

import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodMonthBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;
import play.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodVoToPeriodBoConverter implements VoConverter<PeriodVO, PeriodBO> {

    public PeriodBO convert(PeriodVO vo) {
        PeriodBO bo;

        Logger.warn("===>test1:");

        if (vo instanceof PeriodYearVO) {

            Logger.warn("===>test2");

            bo = new PeriodYearBO();

            if (((PeriodYearVO) vo).getNextYear() != null) {
                bo.setNextPeriodId(((PeriodYearVO) vo).getNextYear().getId());
            }
            if (((PeriodYearVO) vo).getPreviousYear() != null) {
                bo.setPreviousPeriodId(((PeriodYearVO) vo).getPreviousYear().getId());
            }

            List<Long> monthId = new ArrayList<>();
            for (PeriodMonthVO monthVO : ((PeriodYearVO) vo).getMonths2()) {
                Logger.info("monthVO:"+monthVO+"/"+monthVO.getCode());
                monthId.add(monthVO.getId());
            }
            ((PeriodYearBO) bo).setMonthIds(monthId);

            List<Long> quarterId = new ArrayList<>();
            for (PeriodQuarterVO quarterVO : ((PeriodYearVO) vo).getQuarters()) {
                quarterId.add(quarterVO.getId());
            }
            ((PeriodYearBO) bo).setQuarterIds(quarterId);

        }  else  if (vo instanceof PeriodQuarterVO) {

            PeriodQuarterVO voq = ((PeriodQuarterVO) vo);

            bo = new PeriodQuarterBO();


            if (voq.getNextQuarter() != null) {
                bo.setNextPeriodId(voq.getNextQuarter().getId());
            }
            if (voq.getPreviousQuarter() != null) {
                bo.setPreviousPeriodId(voq.getPreviousQuarter().getId());
            }
            ((PeriodQuarterBO) bo).setYearId(voq.getPeriodYear().getId());
            List<Long> monthId = new ArrayList<>();


            Logger.warn("===>test3.3:"+voq.getMonths());

            for (PeriodMonthVO monthVO : voq.getMonths()) {
                Logger.warn("       =>" + monthVO);
                monthId.add(monthVO.getId());
            }
            Logger.warn("===>test3.4");
            ((PeriodQuarterBO) bo).setMonthIds(monthId);

        }else{

            bo = new PeriodMonthBO();
            if (((PeriodMonthVO) vo).getNextMonth() != null) {
                bo.setNextPeriodId(((PeriodMonthVO) vo).getNextMonth().getId());
            }
            if (((PeriodMonthVO) vo).getPreviousMonth() != null) {
                bo.setPreviousPeriodId(((PeriodMonthVO) vo).getPreviousMonth().getId());
            }
            ((PeriodMonthBO) bo).setYearId(((PeriodMonthVO) vo).getPeriodYear().getId());
            ((PeriodMonthBO) bo).setQuarterId(((PeriodMonthVO) vo).getPeriodQuarter().getId());
        }

        bo.setId(vo.getId());
        bo.setCode(vo.getCode());
        bo.setStartDate(vo.getStartDate());
        bo.setEndDate(vo.getEndDate());
        bo.setNbDay(vo.getNbDay());


        return bo;
    }
}
