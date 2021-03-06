package task3.currency.pages.parsing;

import org.openqa.selenium.WebDriver;
import task3.currency.pages.UniversalbankCurrencyPage;

import static task3.currency.pages.parsing.RegexMatches.getRegexMatches;

public class UniversalbankCurrencyPageParsing extends UniversalbankCurrencyPage {

    private String pageSourceNoSpaces;

    public UniversalbankCurrencyPageParsing(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.goToPage();

        //remove whitespaces from pagesource
        pageSourceNoSpaces = driver.getPageSource().replaceAll("\\s", "");
    }

    @Override
    protected double getUsdUahBidPrice() {

        //find web element containing quote
        String quoteRegex = "<tr><tdclass=\"currencyrisep-b-xs-2p-y-1-sm\">USD<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }


    @Override
    protected double getUsdUahAskPrice() {

        //find web element containing quote
        String quoteRegex = "<tr><tdclass=\"currencyrisep-b-xs-2p-y-1-sm\">USD<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d").get(1);//get second match
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahBidPrice() {

        //find web element containing quote
        String quoteRegex = "<tr><tdclass=\"currencydownp-b-xs-2p-y-1-sm\">EUR<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahAskPrice() {

        //find web element containing quote
        String quoteRegex = "<tr><tdclass=\"currencydownp-b-xs-2p-y-1-sm\">EUR<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td><tdclass=\"p-b-xs-2p-y-1-sm\">\\d\\d\\.\\d\\d<\\/td>";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d\\d.\\d\\d").get(1);
        return Double.parseDouble(quoteString);
    }
}
