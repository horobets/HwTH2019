package task3.currency.pages.parsing;

import org.openqa.selenium.WebDriver;
import task3.currency.pages.UniversalbankCurrencyPage;

public class UniversalbankCurrencyPageParsing extends UniversalbankCurrencyPage {

    private String pageSource;

    public UniversalbankCurrencyPageParsing(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.goToPage();
        pageSource = driver.getPageSource();
    }

    @Override
    protected double getUsdUahBidPrice() {





        return super.getUsdUahBidPrice();
    }

    @Override
    protected double getUsdUahAskPrice() {
        return super.getUsdUahAskPrice();
    }

    @Override
    protected double getEurUahBidPrice() {
        return super.getEurUahBidPrice();
    }

    @Override
    protected double getEurUahAskPrice() {
        return super.getEurUahAskPrice();
    }
}
