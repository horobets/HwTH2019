package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;
import task3.currency.PricePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UkrsibbankCurrencyPage extends BankCurrencyInfoBasePage {
    public UkrsibbankCurrencyPage(WebDriver driver) {
        super(driver);

        bankName = "Ukrsibbank";
    }

    private By usdUahBidRateBy = By.xpath("(//tr[td[contains(text(), 'USD')]]/td[span[@class='mobile-curr-name']])[1]");
    private By usdUahAskRateBy = By.xpath("(//tr[td[contains(text(), 'USD')]]/td[span[@class='mobile-curr-name']])[2]");
    private By eurUahBidRateBy = By.xpath("(//tr[td[contains(text(), 'EUR')]]/td[span[@class='mobile-curr-name']])[1]");
    private By eurUahAskRateBy = By.xpath("(//tr[td[contains(text(), 'EUR')]]/td[span[@class='mobile-curr-name']])[2]");

    @Override
    public void goToPage() {
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
    }

    @Override
    public PricePair getPricePair(CurrencyPair currencyPair) {
        switch (currencyPair) {
            case USDUAH:
                return new PricePair(getUsdUahBidPrice(), getUsdUahAskPrice());
            case EURUAH:
                return new PricePair(getEurUahBidPrice(), getEurUahAskPrice());
        }
        return null;
    }

    protected double getUsdUahBidPrice() {
        String usdUahRatesString = readText(usdUahBidRateBy);
        return Double.parseDouble(usdUahRatesString);
    }

    protected double getUsdUahAskPrice() {
        String usdUahRatesString = readText(usdUahAskRateBy);
        return Double.parseDouble(usdUahRatesString);
    }

    protected double getEurUahBidPrice() {
        String eurUahRatesString = readText(eurUahBidRateBy);
        return Double.parseDouble(eurUahRatesString);
    }

    protected double getEurUahAskPrice() {
        String eurUahRatesString = readText(eurUahAskRateBy);
        return Double.parseDouble(eurUahRatesString);
    }
}
