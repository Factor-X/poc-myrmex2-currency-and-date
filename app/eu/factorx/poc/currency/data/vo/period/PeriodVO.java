package eu.factorx.poc.currency.data.vo.period;

import eu.factorx.poc.currency.data.vo.VO;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by florian on 8/01/15.
 */
@Entity
@Table(name = "period")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PeriodVO extends VO {

    @Id
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Integer nbDay;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;



    public PeriodVO() {
    }

    public PeriodVO(String code, Integer nbDay, Date startDate, Date endDate) {
        this.code = code;
        this.nbDay = nbDay;
        this.startDate = startDate;
        this.endDate = endDate;
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
        return "Period{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nbDay=" + nbDay +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public PeriodVO getPreviousPeriod(PeriodVO periodVO) {
        if(periodVO instanceof PeriodQuarterVO){
            return  ((PeriodQuarterVO) periodVO).getPreviousQuarter();
        }
        else if(periodVO instanceof PeriodYearVO){
            return  ((PeriodYearVO) periodVO).getPreviousYear();
        }
        else if(periodVO instanceof PeriodMonthVO){
            return  ((PeriodMonthVO) periodVO).getPreviousMonth();
        }
        return null;
    }
}
