package task3.currency.pages.parsing;

import org.openqa.selenium.WebDriver;
import task3.currency.pages.OschadbankCurrencyPage;
import static task3.currency.pages.parsing.RegexMatches.getRegexMatches;

public class OschadbankCurrencyPageParsing extends OschadbankCurrencyPage {

    private String pageSource;

    public OschadbankCurrencyPageParsing(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.goToPage();
        pageSource = driver.getPageSource();
    }

    @Override
    protected double getUsdUahBidPrice() {

        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<strongclass=\"buy-USD\"data-buy=\"\\d\\d.\\d\\d\\d\\d\">";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }


    @Override
    protected double getUsdUahAskPrice() {

        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<strongclass=\"sell-USD\"data-sell=\"\\d\\d.\\d\\d\\d\\d\">";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d\\d\\d").get(0);
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahBidPrice() {


        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<strongclass=\"buy-EUR\"data-buy=\"\\d\\d.\\d\\d\\d\\d\">";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahAskPrice() {


        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<strongclass=\"sell-EUR\"data-sell=\"\\d\\d.\\d\\d\\d\\d\">";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }
}
