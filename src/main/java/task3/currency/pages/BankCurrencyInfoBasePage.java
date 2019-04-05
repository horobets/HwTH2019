package task3.currency.pages;

import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;

public abstract class BankCurrencyInfoBasePage extends BasePage {
    public BankCurrencyInfoBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void goToPage();
    public abstract BankExchangeRatesInfo getBankExchangeRates();
    public abstract CurrencyInfo getPricePair(CurrencyPair currencyPair);
}
