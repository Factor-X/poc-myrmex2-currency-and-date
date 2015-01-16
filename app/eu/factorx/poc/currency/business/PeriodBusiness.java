package eu.factorx.poc.currency.business;

import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public interface PeriodBusiness {

    public List<PeriodBO> getYearPeriod();

    PeriodBO findById(Long periodId);

    List<PeriodBO> findAllYear();

    PeriodYearBO findYearByCode(String code);

    PeriodQuarterBO findQuarterByCode(PeriodYearBO periodYear, String code);
}
