package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;

import java.util.ArrayList;
import java.util.List;

public class PrivatbankCurrencyPage extends BankCurrencyInfoBasePage {
    public PrivatbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    By usdUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'USD')]]/div[@class='section-content rate']");
    By eurUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'EUR')]]/div[@class='section-content rate']");

    @Override
    public void goToPage() {
        driver.get("https://www.privat24.ua");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        List<CurrencyInfo> privatbankCurrencyRates = new ArrayList<>();

        privatbankCurrencyRates.add(getPricePair(CurrencyPair.USDUAH));
        privatbankCurrencyRates.add(getPricePair(CurrencyPair.EURUAH));

        BankExchangeRatesInfo privatbankExchangeRatesInfo = new BankExchangeRatesInfo("Privatbank", driver.getCurrentUrl(), privatbankCurrencyRates);

        return privatbankExchangeRatesInfo;
    }

    @Override
    public CurrencyInfo getPricePair(CurrencyPair currencyPair) {
        switch (currencyPair) {
            case USDUAH:
                return new CurrencyInfo(getUsdUahBidPrice(), getUsdUahAskPrice(), CurrencyPair.USDUAH);
            case EURUAH:
                return new CurrencyInfo(getEurUahBidPrice(), getEurUahAskPrice(), CurrencyPair.EURUAH);
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
