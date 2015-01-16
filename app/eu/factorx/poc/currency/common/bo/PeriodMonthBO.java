package eu.factorx.poc.currency.common.bo;

import java.util.List;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodMonthBO extends PeriodBO{

    private Long yearId;

    private Long quarterId;

    public Long getYearId() {
        return yearId;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public Long getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(Long quarterId) {
        this.quarterId = quarterId;
    }
}
