package eu.factorx.poc.currency.common.bo;

import eu.factorx.poc.currency.common.constants.Currency;

/**
 * Created by florian on 14/01/15.
 */
public class CurrencyExchangeValueBO extends BO{

    private Long id;

    private Currency currency1;

    private Currency currency2;

    private PeriodBO period;

    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Currency currency1) {
        this.currency1 = currency1;
    }

    public Currency getCurrency2() {
        return currency2;
    }

    public void setCurrency2(Currency currency2) {
        this.currency2 = currency2;
    }

    public PeriodBO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodBO period) {
        this.period = period;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeValueBO{" +
                "id=" + id +
                ", currency1=" + currency1 +
                ", currency2=" + currency2 +
                ", period=" + period +
                ", value=" + value +
                '}';
    }
}
