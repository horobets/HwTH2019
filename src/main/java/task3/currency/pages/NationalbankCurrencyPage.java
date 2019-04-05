package task3.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task3.currency.BankExchangeRatesInfo;
import task3.currency.CurrencyInfo;
import task3.currency.CurrencyPair;

import java.util.ArrayList;
import java.util.List;

public class NationalbankCurrencyPage extends BankCurrencyInfoBasePage {
    public NationalbankCurrencyPage(WebDriver driver) {
        super(driver);
    }

    By usdUahRateBy = By.xpath("(//div[@class='serviceZone2'][1]//td[@class='value'])[1]");
    By eurUahRateBy = By.xpath("(//div[@class='serviceZone2'][1]//td[@class='value'])[3]");

    @Override
    public void goToPage() {
        driver.get("http://www.bank.gov.ua");
    }

    @Override
    public BankExchangeRatesInfo getBankExchangeRates() {

        List<CurrencyInfo> bankCurrencyRates = new ArrayList<>();

        bankCurrencyRates.add(getPricePair(CurrencyPair.USDUAH));
        bankCurrencyRates.add(getPricePair(CurrencyPair.EURUAH));

        BankExchangeRatesInfo bankExchangeRatesInfo = new BankExchangeRatesInfo("National Bank", driver.getCurrentUrl(), bankCurrencyRates);

        return bankExchangeRatesInfo;
    }

    @Override
    public CurrencyInfo getPricePair(CurrencyPair currencyPair) {
        switch (currencyPair) {
            case USDUAH:
                double usdUahPrice = getUsdUahPrice();
                return new CurrencyInfo(usdUahPrice, usdUahPrice, CurrencyPair.USDUAH);
            case EURUAH:
                double eurUahPrice = getEurUahPrice();
                return new CurrencyInfo(eurUahPrice, eurUahPrice, CurrencyPair.EURUAH);
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
