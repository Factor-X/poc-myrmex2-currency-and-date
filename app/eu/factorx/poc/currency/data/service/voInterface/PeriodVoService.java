package eu.factorx.poc.currency.data.service.voInterface;

import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;

/**
 * Created by florian on 8/01/15.
 */
public interface PeriodVoService {

    public void saveOrUpdate(PeriodVO periodVO);

    PeriodVO findVoById(Long period);

    PeriodQuarterVO findVoQuarterByCode(PeriodVO periodYear, String code);

    PeriodMonthVO findVoMonthByCode(PeriodVO previousYear, String s);

    PeriodYearVO findVoYearByCode(String s);
}
