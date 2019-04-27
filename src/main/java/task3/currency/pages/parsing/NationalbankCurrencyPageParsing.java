package task3.currency.pages.parsing;

import org.openqa.selenium.WebDriver;
import task3.currency.pages.NationalbankCurrencyPage;

import static task3.currency.pages.parsing.RegexMatches.getRegexMatches;

public class NationalbankCurrencyPageParsing extends NationalbankCurrencyPage {

    private String pageSourceNoSpaces;

    public NationalbankCurrencyPageParsing(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.goToPage();

        //remove whitespaces from pagesource
        pageSourceNoSpaces = driver.getPageSource().replaceAll("\\s", "");
    }

    @Override
    protected double getUsdUahPrice() {

        //find web element containing quote
        String quoteRegex = "<divclass=\"serviceZone2\".*\\d\\d\\d\\d.\\d\\d\\d\\d.*<\\/table>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d\\d\\d.\\d\\d\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString) / 100;
    }

    @Override
    protected double getEurUahPrice() {

        //find web element containing quote
        String quoteRegex = "<divclass=\"serviceZone2\".*\\d\\d\\d\\d.\\d\\d\\d\\d.*<\\/table>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d\\d\\d.\\d\\d\\d\\d").get(2);
        return Double.parseDouble(quoteString) / 100;
    }
}
