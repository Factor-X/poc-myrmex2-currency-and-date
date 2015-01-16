package eu.factorx.poc.currency.common.bo;

import eu.factorx.poc.currency.common.constants.PeriodType;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;

import java.util.Date;

/**
 * Created by florian on 14/01/15.
 */
public abstract class PeriodBO extends BO{

    private Long id;

    private String code;

    private Integer nbDay;

    private Date startDate;

    private Date endDate;

    private Long previousPeriodId;

    private Long nextPeriodId;


    public Long getPreviousPeriodId() {
        return previousPeriodId;
    }

    public void setPreviousPeriodId(Long previousPeriodId) {
        this.previousPeriodId = previousPeriodId;
    }

    public Long getNextPeriodId() {
        return nextPeriodId;
    }

    public void setNextPeriodId(Long nextPeriodId) {
        this.nextPeriodId = nextPeriodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNbDay() {
        return nbDay;
    }

    public void setNbDay(Integer nbDay) {
        this.nbDay = nbDay;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PeriodBO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nbDay=" + nbDay +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
