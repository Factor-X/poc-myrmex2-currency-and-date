package eu.factorx.poc.currency.common.bo;

import java.util.Date;
import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodYearBO extends PeriodBO{

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
