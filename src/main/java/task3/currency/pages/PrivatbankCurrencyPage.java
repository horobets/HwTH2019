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

public class PrivatbankCurrencyPage extends BankCurrencyInfoBasePage {
    public PrivatbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    private By usdUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'USD')]]/div[@class='section-content rate']");
    private By eurUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'EUR')]]/div[@class='section-content rate']");

    @Override
    public void goToPage() {
        driver.get("https://www.privat24.ua");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        Map<CurrencyPair, PricePair> bankCurrencyRates = new HashMap<>();

        bankCurrencyRates.put(CurrencyPair.USDUAH, getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.put(CurrencyPair.EURUAH, getPricePair(CurrencyPair.EURUAH));

        return new BankExchangeRatesInfo("Privatbank", driver.getCurrentUrl(), bankCurrencyRates);
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
        String privatbankUsdUahRatesString = readText(usdUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the first numeric part of the string
        String privatbankUsdUahBidString = privatbankUsdUahRatesString.substring(0, 6);

        return Double.parseDouble(privatbankUsdUahBidString);
    }

    private double getUsdUahAskPrice() {
        String privatbankUsdUahRatesString = readText(usdUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the last numeric part of the string
        String privatbankUsdUahAskString = privatbankUsdUahRatesString.substring(privatbankUsdUahRatesString.length() - 6);

        return Double.parseDouble(privatbankUsdUahAskString);
    }

    private double getEurUahBidPrice() {
        String privatbankEurUahRatesString = readText(eurUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the first numeric part of the string
        String privatbankEurUahBidString = privatbankEurUahRatesString.substring(0, 6);

        return Double.parseDouble(privatbankEurUahBidString);
    }

    private double getEurUahAskPrice() {
        String privatbankEurUahRatesString = readText(eurUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the last numeric part of the string
        String privatbankEurUahAskString = privatbankEurUahRatesString.substring(privatbankEurUahRatesString.length() - 6);

        return Double.parseDouble(privatbankEurUahAskString);
    }
}