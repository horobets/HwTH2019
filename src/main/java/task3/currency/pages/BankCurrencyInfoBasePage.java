package task3.currency.pages;

import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyPair;
import task3.currency.PricePair;

import java.util.HashMap;
import java.util.Map;

public abstract class BankCurrencyInfoBasePage extends BasePage {

    protected String bankName;

    public BankCurrencyInfoBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void goToPage();

    public BankExchangeRatesInfo getBankExchangeRates() {

        Map<CurrencyPair, PricePair> bankCurrencyRates = new HashMap<>();

        bankCurrencyRates.put(CurrencyPair.USDUAH, getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.put(CurrencyPair.EURUAH, getPricePair(CurrencyPair.EURUAH));

        return new BankExchangeRatesInfo(bankName, driver.getCurrentUrl(), bankCurrencyRates);
    }

    public abstract PricePair getPricePair(CurrencyPair currencyPair);
}
