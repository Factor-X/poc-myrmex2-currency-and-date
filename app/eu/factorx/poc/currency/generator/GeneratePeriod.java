package eu.factorx.poc.currency.generator;

import eu.factorx.poc.currency.data.service.voInterface.PeriodVoService;
import eu.factorx.poc.currency.data.vo.period.PeriodMonthVO;
import eu.factorx.poc.currency.data.vo.period.PeriodQuarterVO;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;
import eu.factorx.poc.currency.data.vo.period.PeriodYearVO;
import play.Logger;
import play.db.ebean.Transactional;
import eu.factorx.poc.currency.data.service.impl.PeriodServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by florian on 8/01/15.
 */
public class GeneratePeriod {

    //service
    private PeriodVoService periodService = new PeriodServiceImpl();

    //converter
    //private PeriodBoToPeriodVoConverter periodBoToPeriodVoConverter = new PeriodBoToPeriodVoConverter();

    DateFormat format = new SimpleDateFormat("yyyyMMdd");

    PeriodMonthVO previousMonth = null;
    PeriodQuarterVO previousQuarter = null;
    PeriodYearVO previousYear = null;

    public void generatePeriod(int startYear, int endYear) {
        try {
            for (int year = startYear; year <= endYear; year++) {
                generateYear(year);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    private void generateYear(int year) throws ParseException {


        //generate by year

        Logger.info("Start period generation for " + year + "...");

        //is there a leap year ?
        boolean isLeapYEar = isLeapYear(year);

        PeriodYearVO periodYear = new PeriodYearVO(year + "", ((isLeapYEar) ? 366 : 365), format.parse(year + "0101"), format.parse(year + "1231"));
        periodYear.setPreviousYear(previousYear);

        //generate quarter
        //nbDay will be computed after
        PeriodQuarterVO q1 = new PeriodQuarterVO("Q1", ((isLeapYEar) ? 91 : 90), format.parse(year + "0101"), format.parse(year + "0331"));
        PeriodQuarterVO q2 = new PeriodQuarterVO("Q2", 91, format.parse(year + "0401"), format.parse(year + "0630"));
        PeriodQuarterVO q3 = new PeriodQuarterVO("Q3", 92, format.parse(year + "0701"), format.parse(year + "0930"));
        PeriodQuarterVO q4 = new PeriodQuarterVO("Q4", 92, format.parse(year + "1001"), format.parse(year + "1231"));

        //add to year
        periodYear.addQuarter(q1);
        periodYear.addQuarter(q2);
        periodYear.addQuarter(q3);
        periodYear.addQuarter(q4);

        q1.setPeriodYear(periodYear);
        q2.setPeriodYear(periodYear);
        q3.setPeriodYear(periodYear);
        q4.setPeriodYear(periodYear);


        //generate month
        PeriodMonthVO m1 = new PeriodMonthVO("1", 31, format.parse(year + "0101"), format.parse(year + "0131"));
        PeriodMonthVO m2 = new PeriodMonthVO("2", ((isLeapYEar) ? 28 : 29), format.parse(year + "0201"), ((isLeapYEar) ? format.parse(year + "0229") : format.parse(year + "0228")));
        PeriodMonthVO m3 = new PeriodMonthVO("3", 31, format.parse(year + "0301"), format.parse(year + "0331"));

        PeriodMonthVO m4 = new PeriodMonthVO("4", 30, format.parse(year + "0401"), format.parse(year + "0430"));
        PeriodMonthVO m5 = new PeriodMonthVO("5", 31, format.parse(year + "0501"), format.parse(year + "0531"));
        PeriodMonthVO m6 = new PeriodMonthVO("6", 30, format.parse(year + "0601"), format.parse(year + "0630"));

        PeriodMonthVO m7 = new PeriodMonthVO("7", 31, format.parse(year + "0701"), format.parse(year + "0731"));
        PeriodMonthVO m8 = new PeriodMonthVO("8", 31, format.parse(year + "0801"), format.parse(year + "0831"));
        PeriodMonthVO m9 = new PeriodMonthVO("9", 30, format.parse(year + "0901"), format.parse(year + "0930"));

        PeriodMonthVO m10 = new PeriodMonthVO("10", 31, format.parse(year + "1001"), format.parse(year + "1031"));
        PeriodMonthVO m11 = new PeriodMonthVO("11", 30, format.parse(year + "1101"), format.parse(year + "1131"));
        PeriodMonthVO m12 = new PeriodMonthVO("12", 31, format.parse(year + "1201"), format.parse(year + "1231"));

        //add year
        m1.setPeriodYear(periodYear);
        m2.setPeriodYear(periodYear);
        m3.setPeriodYear(periodYear);
        m4.setPeriodYear(periodYear);
        m5.setPeriodYear(periodYear);
        m6.setPeriodYear(periodYear);
        m7.setPeriodYear(periodYear);
        m8.setPeriodYear(periodYear);
        m9.setPeriodYear(periodYear);
        m10.setPeriodYear(periodYear);
        m11.setPeriodYear(periodYear);
        m12.setPeriodYear(periodYear);

        //add to quarter
        q1.addMonth(m1);
        q1.addMonth(m2);
        q1.addMonth(m3);

        q2.addMonth(m4);
        q2.addMonth(m5);
        q2.addMonth(m6);

        q3.addMonth(m7);
        q3.addMonth(m8);
        q3.addMonth(m9);

        q4.addMonth(m10);
        q4.addMonth(m11);
        q4.addMonth(m12);

        //set previous
        m1.setPreviousMonth(previousMonth);
        m2.setPreviousMonth(m1);
        m3.setPreviousMonth(m2);
        m4.setPreviousMonth(m3);
        m5.setPreviousMonth(m4);
        m6.setPreviousMonth(m5);
        m7.setPreviousMonth(m6);
        m8.setPreviousMonth(m7);
        m9.setPreviousMonth(m8);
        m10.setPreviousMonth(m9);
        m11.setPreviousMonth(m10);
        m12.setPreviousMonth(m11);

        //set previous
        q1.setPreviousQuarter(previousQuarter);
        q2.setPreviousQuarter(q1);
        q3.setPreviousQuarter(q2);
        q4.setPreviousQuarter(q3);


        PeriodVO previousYear = periodService.findVoYearByCode((year - 1) + "");
        if (previousYear != null) {
            periodYear.setPreviousYear((PeriodYearVO) previousYear);
            m1.setPreviousMonth(periodService.findVoMonthByCode(previousYear, "12"));
            q1.setPreviousQuarter(periodService.findVoQuarterByCode(previousYear, "Q4"));
        }

        //save
        Logger.info(periodYear+"");
        periodService.saveOrUpdate(periodYear);

        Logger.info("... year " + year + " finish !");
    }

    private boolean isLeapYear(int year) {
        return ((year % 4 == 0) && year % 100 != 0) || year % 400 == 0;
    }

}
