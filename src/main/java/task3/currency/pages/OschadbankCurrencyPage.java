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

public class OschadbankCurrencyPage extends BankCurrencyInfoBasePage {
    public OschadbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    private By usdUahBidRateBy = By.xpath("//strong[@class='buy-USD']");
    private By usdUahAskRateBy = By.xpath("//strong[@class='sell-USD']");
    private By eurUahBidRateBy = By.xpath("//strong[@class='buy-EUR']");
    private By eurUahAskRateBy = By.xpath("//strong[@class='sell-EUR']");

    @Override
    public void goToPage() {
        driver.get("http://www.oschadbank.ua/ua/");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        Map<CurrencyPair, PricePair> bankCurrencyRates = new HashMap<>();

        bankCurrencyRates.put(CurrencyPair.USDUAH, getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.put(CurrencyPair.EURUAH, getPricePair(CurrencyPair.EURUAH));

        return new BankExchangeRatesInfo("Oschadbank", driver.getCurrentUrl(), bankCurrencyRates);
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

    private double getUsdUahBidPrice() {
        String usdUahRatesString = readText(usdUahBidRateBy);
        return Double.parseDouble(usdUahRatesString);
    }

    private double getUsdUahAskPrice() {
        String usdUahRatesString = readText(usdUahAskRateBy);
        return Double.parseDouble(usdUahRatesString);
    }

    private double getEurUahBidPrice() {
        String eurUahRatesString = readText(eurUahBidRateBy);
        return Double.parseDouble(eurUahRatesString);
    }

    private double getEurUahAskPrice() {
        String eurUahRatesString = readText(eurUahAskRateBy);
        return Double.parseDouble(eurUahRatesString);
    }
}
