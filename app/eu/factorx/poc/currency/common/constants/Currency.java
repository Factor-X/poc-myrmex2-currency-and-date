package eu.factorx.poc.currency.common.constants;

import javax.persistence.AttributeConverter;

/**
 * Created by florian on 8/01/15.
 */
public enum Currency {

    USD("?", "USD", "?"),
    EUR("?", "EU2", "?"),
    ALL("?", "ALL", "?"),
    DZD("?", "DZD", "?"),
    AOA("?", "AOA", "?"),
    XCD("?", "XCD", "?"),
    ARS("?", "ARS", "?"),
    AMD("?", "AMD", "?"),
    AWG("?", "AWG", "?"),
    AUD("?", "AUD", "?"),
    AZN("?", "AZN", "?"),
    BSD("?", "BSD", "?"),
    BHD("?", "BHD", "?"),
    BDT("?", "BDT", "?"),
    BBD("?", "BBD", "?"),
    BYR("?", "BYR", "?"),
    BZD("?", "BZD", "?"),
    BMD("?", "BMD", "?"),
    BTN("?", "BTN", "?"),
    BOB("?", "BOB", "?"),
    BAM("?", "BAM", "?"),
    BWP("?", "BWP", "?"),
    BRL("?", "BRL", "?"),
    BND("?", "BND", "?"),
    BGN("?", "BGN", "?"),
    MMK("?", "MMK", "?"),
    BIF("?", "BIF", "?"),
    KHR("?", "KHR", "?"),
    XAF("?", "XAF", "?"),
    CAD("?", "CAD", "?"),
    CVE("?", "CVE", "?"),
    KYD("?", "KYD", "?"),
    CLP("?", "CLP", "?"),
    CNY("?", "CNY", "?"),
    COP("?", "COP", "?"),
    KMF("?", "KMF", "?"),
    CDF("?", "CDF", "?"),
    NZD("?", "NZD", "?"),
    CRC("?", "CRC", "?"),
    HRK("?", "HRK", "?"),
    CUP("?", "CUP", "?"),
    ANG("?", "ANG", "?"),
    CZK("?", "CZK", "?"),
    DKK("?", "DKK", "?"),
    DJF("?", "DJF", "?"),
    DOP("?", "DOP", "?"),
    EGP("?", "EGP", "?"),
    ETB("?", "ETB", "?"),
    FKP("?", "FKP", "?"),
    FJD("?", "FJD", "?"),
    GMD("?", "GMD", "?"),
    GEL("?", "GEL", "?"),
    GHS("?", "GHS", "?"),
    GIP("?", "GIP", "?"),
    GTQ("?", "GTQ", "?"),
    GBP("?", "GBP", "?"),
    GNF("?", "GNF", "?"),
    GYD("?", "GYD", "?"),
    HTG("?", "HTG", "?"),
    HNL("?", "HNL", "?"),
    HKD("?", "HKD", "?"),
    HUF("?", "HUF", "?"),
    ISK("?", "ISK", "?"),
    INR("?", "INR", "?"),
    IDR("?", "IDR", "?"),
    IRR("?", "IRR", "?"),
    IQD("?", "IQD", "?"),
    ILS("?", "ILS", "?"),
    JMD("?", "JMD", "?"),
    JPY("?", "JPY", "?"),
    JOD("?", "JOD", "?"),
    KZT("?", "KZT", "?"),
    KES("?", "KES", "?"),
    KPW("?", "KPW", "?"),
    KWD("?", "KWD", "?"),
    KGS("?", "KGS", "?"),
    LAK("?", "LAK", "?"),
    LBP("?", "LBP", "?"),
    LSL("?", "LSL", "?"),
    LRD("?", "LRD", "?"),
    LYD("?", "LYD", "?"),
    CHF("?", "CHF", "?"),
    LTL("?", "LTL", "?"),
    MOP("?", "MOP", "?"),
    MKD("?", "MKD", "?"),
    MGA("?", "MGA", "?"),
    MWK("?", "MWK", "?"),
    MYR("?", "MYR", "?"),
    MVR("?", "MVR", "?"),
    MUR("?", "MUR", "?"),
    MXN("?", "MXN", "?"),
    MDL("?", "MDL", "?"),
    MNT("?", "MNT", "?"),
    MAD("?", "MAD", "?"),
    MZN("?", "MZN", "?"),
    NAD("?", "NAD", "?"),
    NPR("?", "NPR", "?"),
    XPF("?", "XPF", "?"),
    NIO("?", "NIO", "?"),
    NGN("?", "NGN", "?"),
    TRY("?", "TRY", "?"),
    NOK("?", "NOK", "?"),
    OMR("?", "OMR", "?"),
    PKR("?", "PKR", "?"),
    PAB("?", "PAB", "?"),
    PGK("?", "PGK", "?"),
    PYG("?", "PYG", "?"),
    PEN("?", "PEN", "?"),
    PHP("?", "PHP", "?"),
    PLN("?", "PLN", "?"),
    QAR("?", "QAR", "?"),
    RON("?", "RON", "?"),
    RWF("?", "RWF", "?"),
    SHP("?", "SHP", "?"),
    WST("?", "WST", "?"),
    STD("?", "STD", "?"),
    SAR("?", "SAR", "?"),
    XOF("?", "XOF", "?"),
    RSD("?", "RSD", "?"),
    SCR("?", "SCR", "?"),
    SLL("?", "SLL", "?"),
    SGD("?", "SGD", "?"),
    SBD("?", "SBD", "?"),
    SOS("?", "SOS", "?"),
    ZAR("?", "ZAR", "?"),
    RUB("?", "RUB", "?"),
    LKR("?", "LKR", "?"),
    SDG("?", "SDG", "?"),
    SRD("?", "SRD", "?"),
    SZL("?", "SZL", "?"),
    SEK("?", "SEK", "?"),
    SYP("?", "SYP", "?"),
    TWD("?", "TWD", "?"),
    TJS("?", "TJS", "?"),
    TZS("?", "TZS", "?"),
    THB("?", "THB", "?"),
    TOP("?", "TOP", "?"),
    TTD("?", "TTD", "?"),
    TND("?", "TND", "?"),
    TMT("?", "TMT", "?"),
    UGX("?", "UGX", "?"),
    UAH("?", "UAH", "?"),
    AED("?", "AED", "?"),
    UYU("?", "UYU", "?"),
    UZS("?", "UZS", "?"),
    VUV("?", "VUV", "?"),
    VEF("?", "VEF", "?"),
    VND("?", "VND", "?"),
    YER("?", "YER", "?"),
    ZMW("?", "ZMW", "?");


    private final String name;
    private final String code;
    private final String symbol;
    public static final Currency CURRENCY_VO_COMPARISON_DEFAULT = Currency.EUR;

    Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    public static Currency getByCode(String currency1) {
        for (Currency currency : Currency.values()) {
            if (currency.code.equals(currency1)) {
                return currency;
            }
        }
        return null;
    }
}