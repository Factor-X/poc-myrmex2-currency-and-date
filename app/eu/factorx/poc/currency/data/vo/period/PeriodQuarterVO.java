package eu.factorx.poc.currency.data.vo.period;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by florian on 8/01/15.
 */
@Entity
@DiscriminatorValue("quarter")
@NamedQueries({
        @NamedQuery(name = PeriodQuarterVO.FIND_BY_YEAR_AND_CODE, query = "where code= :code and periodYear.id = :year_id" ),
})
public class PeriodQuarterVO extends PeriodVO {

    public static final String FIND_BY_YEAR_AND_CODE = "PeriodQuarter_FIND_BY_YEAR_AND_CODE";

    @ManyToOne( cascade = CascadeType.ALL)
    private PeriodYearVO periodYear;

    @OneToMany(mappedBy = "periodQuarter",cascade = CascadeType.ALL)
    private Set<PeriodMonthVO> months;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private PeriodQuarterVO previousQuarter;

    @OneToOne(mappedBy = "previousQuarter")
    private PeriodQuarterVO nextQuarter;

    public PeriodQuarterVO(){

    }

    public PeriodQuarterVO(String code, Integer nbDay, Date startDate, Date endDate) {
        super(code, nbDay, startDate, endDate);
    }

    public PeriodYearVO getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(PeriodYearVO periodYear) {
        this.periodYear = periodYear;
    }

    public PeriodQuarterVO getPreviousQuarter() {
        return previousQuarter;
    }

    public void setPreviousQuarter(PeriodQuarterVO previousQuarter) {
        this.previousQuarter = previousQuarter;
    }

    public PeriodQuarterVO getNextQuarter() {
        return nextQuarter;
    }

    public void setNextQuarter(PeriodQuarterVO nextQuarter) {
        this.nextQuarter = nextQuarter;
    }

    public Set<PeriodMonthVO> getMonths() {
        return months;
    }

    public void setMonths(Set<PeriodMonthVO> months) {
        this.months = months;
    }

    public void addMonth(PeriodMonthVO month){
        if(this.months ==null){
            this.months = new HashSet<>();
        }

        this.months.add(month);
    }
}
