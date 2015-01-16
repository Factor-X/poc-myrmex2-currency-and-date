package eu.factorx.poc.currency.common.bo;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodQuarterBO extends PeriodBO{

    private Long yearId;

    private List<Long> monthIds;

    public Long getYearId() {
        return yearId;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public List<Long> getMonthIds() {
        return monthIds;
    }

    public void setMonthIds(List<Long> monthIds) {
        this.monthIds = monthIds;
    }
}
