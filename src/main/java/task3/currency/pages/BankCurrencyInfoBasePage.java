package task3.currency.pages;

import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;
import task3.currency.PricePair;

public abstract class BankCurrencyInfoBasePage extends BasePage {
    public BankCurrencyInfoBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void goToPage();
    public abstract BankExchangeRatesInfo getBankExchangeRates();
    public abstract PricePair getPricePair(CurrencyPair currencyPair);
}
