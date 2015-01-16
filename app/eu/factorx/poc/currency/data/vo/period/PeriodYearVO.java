package eu.factorx.poc.currency.data.vo.period;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by florian on 8/01/15.
 */
@Entity
@DiscriminatorValue("year")
@NamedQueries({
        @NamedQuery(name = PeriodYearVO.FIND_BY_CODE, query = "where code= :code" ),
})
public class PeriodYearVO extends PeriodVO {

    public static final String FIND_BY_CODE = "Period_FIND_BY_CODE";

    @OneToMany(mappedBy = "periodYear",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<PeriodMonthVO> months2;

    @OneToMany(mappedBy = "periodYear",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<PeriodQuarterVO> quarters;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private PeriodYearVO previousYear;

    @OneToOne(mappedBy = "previousYear")
    private PeriodYearVO nextYear;

    public PeriodYearVO(){
    }


    public PeriodYearVO(String code, Integer nbDay, Date startDate, Date endDate) {
        super(code, nbDay, startDate, endDate);
    }

    public PeriodYearVO getPreviousYear() {
        return previousYear;
    }

    public void setPreviousYear(PeriodYearVO previousYear) {
        this.previousYear = previousYear;
    }

    public PeriodYearVO getNextYear() {
        return nextYear;
    }

    public void setNextYear(PeriodYearVO nextYear) {
        this.nextYear = nextYear;
    }

    public Set<PeriodMonthVO> getMonths2() {
        return months2;
    }

    public void setMonths2(Set<PeriodMonthVO> months2) {
        this.months2 = months2;
    }

    public Set<PeriodQuarterVO> getQuarters() {
        return quarters;
    }

    public void setQuarters(Set<PeriodQuarterVO> quarters) {
        this.quarters = quarters;
    }


    public void addMonth(PeriodMonthVO month) {
        if(months2 ==null){
            months2 = new HashSet<>();
        }
        months2.add(month);
    }

    public void addQuarter(PeriodQuarterVO q1) {
        if(quarters ==null){
            quarters = new HashSet<>();
        }
        quarters.add(q1);
    }

    @Override
    public String toString() {
        return "PeriodYearVO{" +
                "months2=" + months2 +
                ", quarters=" + quarters +
                ", previousYear=" + previousYear +
                ", nextYear=" + nextYear +
                '}';
    }
}
