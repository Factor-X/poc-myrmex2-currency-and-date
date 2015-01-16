package eu.factorx.poc.currency.business.impl;

import eu.factorx.poc.currency.business.PeriodBusiness;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.data.service.boInterface.PeriodService;
import eu.factorx.poc.currency.data.service.impl.PeriodServiceImpl;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodBusinessImpl implements PeriodBusiness {

    //service
    private PeriodService periodService = new PeriodServiceImpl();

    @Override
    public List<PeriodBO> getYearPeriod() {
        return periodService.findAllYear();
    }

    @Override
    public PeriodBO findById(Long periodId) {
        return periodService.findById(periodId);
    }

    @Override
    public List<PeriodBO> findAllYear() {
        return periodService.findAllYear();
    }

    @Override
    public PeriodYearBO findYearByCode(String code) {
        return periodService.findYearByCode(code);
    }

    @Override
    public PeriodQuarterBO findQuarterByCode(PeriodYearBO periodYear, String code) {
        return periodService.findQuarterByCode(periodYear,code);
    }
}
