package eu.factorx.poc.currency.deployement.dto;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodYearDTO extends PeriodDTO {

    private List<Long> quarterIds;

    private List<Long> monthIds;

    public List<Long> getQuarterIds() {
        return quarterIds;
    }

    public void setQuarterIds(List<Long> quarterIds) {
        this.quarterIds = quarterIds;
    }

    public List<Long> getMonthIds() {
        return monthIds;
    }

    public void setMonthIds(List<Long> monthIds) {
        this.monthIds = monthIds;
    }
}
