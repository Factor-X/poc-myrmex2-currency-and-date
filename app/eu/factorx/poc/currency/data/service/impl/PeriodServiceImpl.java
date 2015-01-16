package eu.factorx.poc.currency.data.service.impl;

import com.avaje.ebean.Ebean;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodMonthBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.data.voToBoConveter.PeriodVoToPeriodBoConverter;
import eu.factorx.poc.currency.data.service.boInterface.PeriodService;
import eu.factorx.poc.currency.data.service.voInterface.PeriodVoService;
import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florian on 8/01/15.
 */
public class PeriodServiceImpl implements PeriodService, PeriodVoService {

    //converter
    private PeriodVoToPeriodBoConverter periodVoToPeriodBoConverter = new PeriodVoToPeriodBoConverter();


    @Override
    public boolean wasGenerated() {
        return Ebean.find(PeriodVO.class).findList().size() > 0;
    }

    @Override
    public void saveOrUpdate(PeriodVO periodVO) {

        if (periodVO.getId() == null) {
            periodVO.save();
        } else {
            periodVO.update();
        }
    }

    @Override
    public PeriodYearVO findVoYearByCode(String code) {
        return Ebean.createNamedQuery(PeriodYearVO.class, PeriodYearVO.FIND_BY_CODE)
                .setParameter("code", code)
                .findUnique();
    }

    @Override
    public PeriodYearBO findYearByCode(String code) {

        PeriodYearVO vo = findVoYearByCode(code);

        if (vo == null) {
            return null;
        }
        return (PeriodYearBO) periodVoToPeriodBoConverter.convert(vo);
    }

    @Override
    public PeriodMonthVO findVoMonthByCode(PeriodVO periodYear, String code) {
        return Ebean.createNamedQuery(PeriodMonthVO.class, PeriodMonthVO.FIND_BY_YEAR_AND_CODE)
                .setParameter("year_id", periodYear.getId())
                .setParameter("code", code)
                .findUnique();
    }

    @Override
    public PeriodMonthBO findMonthByCode(PeriodBO periodYear, String code) {

        PeriodMonthVO vo = findVoMonthByCode(findVoById(periodYear.getId()), code);

        if (vo == null) {
            return null;
        }
        return (PeriodMonthBO) periodVoToPeriodBoConverter.convert(vo);
    }

    @Override
    public PeriodQuarterVO findVoQuarterByCode(PeriodVO periodYear, String code) {
        return Ebean.createNamedQuery(PeriodQuarterVO.class, PeriodQuarterVO.FIND_BY_YEAR_AND_CODE)
                .setParameter("year_id", periodYear.getId())
                .setParameter("code", code)
                .findUnique();
    }

    @Override
    public PeriodQuarterBO findQuarterByCode(PeriodBO periodYear, String code) {

        PeriodQuarterVO vo = findVoQuarterByCode(findVoById(periodYear.getId()), code);

        if (vo == null) {
            return null;
        }
        return (PeriodQuarterBO) periodVoToPeriodBoConverter.convert(vo);
    }

    @Override
    public List<PeriodBO> findAllYear() {
        List<PeriodBO> bos = new ArrayList<>();

        for (PeriodYearVO vo : Ebean.find(PeriodYearVO.class).findList()) {
            bos.add(periodVoToPeriodBoConverter.convert(vo));
        }
        return bos;
    }

    @Override
    public PeriodVO findVoById(Long period) {
        return Ebean.find(PeriodVO.class).setId(period).findUnique();
    }

    @Override
    public PeriodBO findById(Long period) {
        PeriodVO vo = findVoById(period);

        if (vo == null) {
            return null;
        }

        return periodVoToPeriodBoConverter.convert(vo);
    }

}
