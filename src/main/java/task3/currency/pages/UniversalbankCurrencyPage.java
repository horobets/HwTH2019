package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.CurrencyPair;
import task3.currency.PricePair;

public class UniversalbankCurrencyPage extends BankCurrencyInfoBasePage {
    public UniversalbankCurrencyPage(WebDriver driver) {
        super(driver);

        bankName = "Universalbank";
    }

    private By usdUahBidRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'USD')]]/td[2])[1]");
    private By usdUahAskRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'USD')]]/td[3])[1]");
    private By eurUahBidRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'EUR')]]/td[2])[1]");
    private By eurUahAskRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'EUR')]]/td[3])[1]");

    @Override
    public void goToPage() {
        driver.get("https://www.universalbank.com.ua/");
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
