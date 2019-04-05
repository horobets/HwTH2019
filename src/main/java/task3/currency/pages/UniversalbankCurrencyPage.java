package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;

import java.util.ArrayList;
import java.util.List;

public class UniversalbankCurrencyPage extends BankCurrencyInfoBasePage {
    public UniversalbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    By usdUahBidRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'USD')]]/td[2])[1]");
    By usdUahAskRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'USD')]]/td[3])[1]");
    By eurUahBidRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'EUR')]]/td[2])[1]");
    By eurUahAskRateBy = By.xpath("(//tr[td[contains(@class, 'currency') and contains(text(), 'EUR')]]/td[3])[1]");

    @Override
    public void goToPage() {
        driver.get("https://www.universalbank.com.ua/");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        List<CurrencyInfo> bankCurrencyRates = new ArrayList<>();

        bankCurrencyRates.add(getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.add(getPricePair(CurrencyPair.EURUAH));

        BankExchangeRatesInfo bankExchangeRatesInfo = new BankExchangeRatesInfo("Universalbank", driver.getCurrentUrl(), bankCurrencyRates);

        return bankExchangeRatesInfo;
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
