package eu.factorx.poc.currency.deployement.dto;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodMonthDTO extends PeriodDTO {

    private Long quarterId;

    private PeriodYearDTO periodYear;

    public Long getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(Long quarterId) {
        this.quarterId = quarterId;
    }

    public void setPeriodYear(PeriodYearDTO periodYear) {
        this.periodYear = periodYear;
    }

    public PeriodYearDTO getPeriodYear() {
        return periodYear;
    }
}
