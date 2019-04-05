package task3.currency;

import java.util.List;

public class BankExchangeRatesInfo {
    public BankExchangeRatesInfo(String bankName, String bankUrl, List<CurrencyInfo> exchangeRates) {
        this.bankName = bankName;
        this.bankUrl = bankUrl;
        this.exchangeRates = exchangeRates;
    }

    private String bankName;
    private String bankUrl;
    private List<CurrencyInfo> exchangeRates;

    public String getBankName() {
        return bankName;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public List<CurrencyInfo> getExchangeRates() {
        return exchangeRates;
    }
}
