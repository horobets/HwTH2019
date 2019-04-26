package task3.currency.pages.parsing;

import org.openqa.selenium.WebDriver;
import task3.currency.pages.UkrsibbankCurrencyPage;

import static task3.currency.pages.parsing.Regex.getRegexMatches;

public class UkrsibbankCurrencyPageParsing extends UkrsibbankCurrencyPage {

    private String pageSource;

    public UkrsibbankCurrencyPageParsing(WebDriver driver) {
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
        String quoteRegex = "<td><spanclass=\"mobile-curr-name\">.{1,20}<\\/span>\\d{1,2}.\\d\\d\\d\\d<iclass";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(0);//get first match

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d{1,2}.\\d\\d\\d\\d").get(0);//get first match
        return Double.parseDouble(quoteString);
    }


    @Override
    protected double getUsdUahAskPrice() {

        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<td><spanclass=\"mobile-curr-name\">.{1,20}<\\/span>\\d{1,2}.\\d\\d\\d\\d<iclass";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(1);

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d{1,2}.\\d\\d\\d\\d").get(0);
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahBidPrice() {


        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<td><spanclass=\"mobile-curr-name\">.{1,20}<\\/span>\\d{1,2}.\\d\\d\\d\\d<iclass";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(3);

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d{1,2}.\\d\\d\\d\\d").get(0);
        return Double.parseDouble(quoteString);
    }

    @Override
    protected double getEurUahAskPrice() {


        //remove whitespaces from pagesource
        String pageSourceNoSpaces = pageSource.replaceAll("\\s", "");

        //find web element containing quote
        String quoteRegex = "<td><spanclass=\"mobile-curr-name\">.{1,20}<\\/span>\\d{1,2}.\\d\\d\\d\\d<iclass";
        String elementWithQuote = getRegexMatches(pageSourceNoSpaces, quoteRegex).get(4);

        //extract quote from web element
        String quoteString = getRegexMatches(elementWithQuote, "\\d{1,2}.\\d\\d\\d\\d").get(0);
        return Double.parseDouble(quoteString);
    }
}
