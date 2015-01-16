package eu.factorx.poc.currency.deployement.dto;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodQuarterDTO extends PeriodDTO {

    private PeriodYearDTO periodYear;

    private List<Long> monthIds;


    public PeriodYearDTO getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(PeriodYearDTO periodYear) {
        this.periodYear = periodYear;
    }

    public List<Long> getMonthIds() {
        return monthIds;
    }

    public void setMonthIds(List<Long> monthIds) {
        this.monthIds = monthIds;
    }
}
