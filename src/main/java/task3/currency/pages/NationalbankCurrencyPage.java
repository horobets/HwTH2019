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

public class NationalbankCurrencyPage extends BankCurrencyInfoBasePage {
    public NationalbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    private By usdUahRateBy = By.xpath("(//div[@class='serviceZone2'][1]//td[@class='value'])[1]");
    private By eurUahRateBy = By.xpath("(//div[@class='serviceZone2'][1]//td[@class='value'])[3]");

    @Override
    public void goToPage() {
        driver.get("http://www.bank.gov.ua");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        Map<CurrencyPair, PricePair> bankCurrencyRates = new HashMap<>();


        bankCurrencyRates.put(CurrencyPair.USDUAH, getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.put(CurrencyPair.EURUAH, getPricePair(CurrencyPair.EURUAH));

        return new BankExchangeRatesInfo("National Bank", driver.getCurrentUrl(), bankCurrencyRates);
    }

    @Override
    public PricePair getPricePair(CurrencyPair currencyPair) {
        switch (currencyPair) {
            case USDUAH:
                double usdUahPrice = getUsdUahPrice();
                return new PricePair(usdUahPrice, usdUahPrice); //same bid and ask prices for national bank
            case EURUAH:
                double eurUahPrice = getEurUahPrice();
                return new PricePair(eurUahPrice, eurUahPrice); //same bid and ask prices for national bank
        }
        return null;
    }



    private double getUsdUahPrice() {
        String usdUahRatesString = readText(usdUahRateBy);
        return Double.parseDouble(usdUahRatesString)/100;
    }

    private double getEurUahPrice() {
        String eurUahRatesString = readText(eurUahRateBy);
        return Double.parseDouble(eurUahRatesString)/100;
    }

}
