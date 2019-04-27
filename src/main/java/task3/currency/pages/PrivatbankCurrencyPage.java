package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.CurrencyPair;
import task3.currency.PricePair;


public class PrivatbankCurrencyPage extends BankCurrencyInfoBasePage {
    public PrivatbankCurrencyPage(WebDriver driver) {
        super(driver);

        bankName = "Privatbank";
    }

    private By usdUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'USD')]]/div[@class='section-content rate']");
    private By eurUahRateBy = By.xpath("//div[@class='exchange-rate-module']/div[div[contains(text(), 'EUR')]]/div[@class='section-content rate']");

    @Override
    public void goToPage() {
        driver.get("https://www.privat24.ua");
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
        String privatbankUsdUahRatesString = readText(usdUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the first numeric part of the string
        String privatbankUsdUahBidString = privatbankUsdUahRatesString.substring(0, 6);

        return Double.parseDouble(privatbankUsdUahBidString);
    }

    protected double getUsdUahAskPrice() {
        String privatbankUsdUahRatesString = readText(usdUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the last numeric part of the string
        String privatbankUsdUahAskString = privatbankUsdUahRatesString.substring(privatbankUsdUahRatesString.length() - 6);

        return Double.parseDouble(privatbankUsdUahAskString);
    }

    protected double getEurUahBidPrice() {
        String privatbankEurUahRatesString = readText(eurUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the first numeric part of the string
        String privatbankEurUahBidString = privatbankEurUahRatesString.substring(0, 6);

        return Double.parseDouble(privatbankEurUahBidString);
    }

    protected double getEurUahAskPrice() {
        String privatbankEurUahRatesString = readText(eurUahRateBy);

        //string value format: 26.750 / 27.100 - so we need to extract the last numeric part of the string
        String privatbankEurUahAskString = privatbankEurUahRatesString.substring(privatbankEurUahRatesString.length() - 6);

        return Double.parseDouble(privatbankEurUahAskString);
    }
}