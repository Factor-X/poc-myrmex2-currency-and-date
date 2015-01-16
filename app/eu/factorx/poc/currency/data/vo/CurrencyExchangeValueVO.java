package eu.factorx.poc.currency.data.vo;

import eu.factorx.poc.currency.common.constants.Currency;
import eu.factorx.poc.currency.data.vo.period.PeriodVO;

import javax.persistence.*;

/**
 * Created by florian on 8/01/15.
 */
@Entity
@Table(name = "currency_exchange_value")
@NamedQueries({
        @NamedQuery(name = CurrencyExchangeValueVO.FIND_BY_CURRENCIES_AND_PERIOD, query = "where currency1 = :currency1 and currency2 = :currency2 and period.id = :period_id" ),
})
public class CurrencyExchangeValueVO extends VO {

    //queries
    public static final String FIND_BY_CURRENCIES_AND_PERIOD = "CurrencyExchangeValue_FIND_BY_CURRENCIES_AND_PERIOD";

    @Id
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency1;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency2;

    @ManyToOne(optional = false)
    private PeriodVO period;

    @Column(nullable = false)
    private Double value;

    public CurrencyExchangeValueVO() {
    }

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

    public PeriodVO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodVO period) {
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
        return "CurrencyExchangeValue{" +
                "value=" + value +
                ", period=" + period +
                ", currency2=" + currency2 +
                ", currency1=" + currency1 +
                '}';
    }
}
