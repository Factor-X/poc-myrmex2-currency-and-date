package eu.factorx.poc.currency.data.vo.period;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by florian on 8/01/15.
 */
@Entity
@DiscriminatorValue("month")
@NamedQueries({
        @NamedQuery(name = PeriodMonthVO.FIND_BY_YEAR_AND_CODE, query = "where code= :code and periodYear.id= :year_id" ),
})
public class PeriodMonthVO extends PeriodVO {

    public static final String FIND_BY_YEAR_AND_CODE = "PeriodMonth_FIND_BY_YEAR_AND_CODE";

    @ManyToOne( cascade =  {CascadeType.MERGE,CascadeType.PERSIST})
    private PeriodYearVO periodYear;

    @ManyToOne(cascade =  {CascadeType.MERGE,CascadeType.PERSIST})
    private PeriodQuarterVO periodQuarter;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private PeriodMonthVO previousMonth;

    @OneToOne(mappedBy = "previousMonth")
    private PeriodMonthVO nextMonth;

    public PeriodMonthVO(){

    }

    public PeriodMonthVO(String code, Integer nbDay, Date startDate, Date endDate) {
        super(code, nbDay, startDate, endDate);
    }

    public PeriodYearVO getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(PeriodYearVO periodYear) {
        this.periodYear = periodYear;
    }

    public PeriodMonthVO getPreviousMonth() {
        return previousMonth;
    }

    public void setPreviousMonth(PeriodMonthVO previousMonth) {
        this.previousMonth = previousMonth;
    }

    public PeriodMonthVO getNextMonth() {
        return nextMonth;
    }

    public void setNextMonth(PeriodMonthVO nextMonth) {
        this.nextMonth = nextMonth;
    }

    public PeriodQuarterVO getPeriodQuarter() {
        return periodQuarter;
    }

    public void setPeriodQuarter(PeriodQuarterVO periodQuarter) {
        this.periodQuarter = periodQuarter;
    }
}
