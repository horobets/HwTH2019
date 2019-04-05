package task3.currency;

import java.util.List;
import java.util.Map;

public class BankExchangeRatesInfo {
    public BankExchangeRatesInfo(String bankName, String bankUrl, Map<CurrencyPair, PricePair> exchangeRates) {
        this.bankName = bankName;
        this.bankUrl = bankUrl;
        this.exchangeRates = exchangeRates;
    }

    private String bankName;
    private String bankUrl;

    private Map<CurrencyPair, PricePair> exchangeRates;

    public String getBankName() {
        return bankName;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public Map<CurrencyPair, PricePair> getExchangeRates() {
        return exchangeRates;
    }

}
