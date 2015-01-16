package eu.factorx.poc.currency.data.service.boInterface;

import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodMonthBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;

import java.util.List;

/**
 * Created by florian on 8/01/15.
 */
public interface PeriodService {
    boolean wasGenerated();

    PeriodYearBO findYearByCode(String code);

    PeriodMonthBO findMonthByCode(PeriodBO periodYear,String code);

    PeriodQuarterBO findQuarterByCode(PeriodBO periodYear,String code);

    List<PeriodBO> findAllYear();

    PeriodBO findById(Long period);
}
