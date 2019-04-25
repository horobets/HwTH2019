package task3.currency;

import org.testng.annotations.Test;
import task3.currency.pages.BankCurrencyInfoBasePage;
import task3.currency.pages.parsing.OschadbankCurrencyPageParsing;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesPageSourceParsingTest extends ExchangeRatesTest {


    @Test
    public void printSourceParsedExchangeRatesInfo() {

        List<BankExchangeRatesInfo> banksExchangeRates = new ArrayList<>();

        // get Privatbank rates from page source
        BankCurrencyInfoBasePage bankPage;// = new PrivatbankCurrencyPage(driver);
 /*       bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Ukrsibbank rates from page source
        bankPage = new UkrsibbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Universalbank rates from page source
        bankPage = new UniversalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());
*/
        // get Oschadbank rates from page source
        bankPage = new OschadbankCurrencyPageParsing(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());
/*
        // get Nationalbank rates from page source
        bankPage = new NationalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());
*/
        // output all Banks exchange Rates from page source
        for (BankExchangeRatesInfo bankExchangeRates : banksExchangeRates) {
            printBankExchangeRates(bankExchangeRates);
        }

        // calculate and output average rates
        printAverageRates(banksExchangeRates);

        // best USD BUY prices bank:
        System.out.println("\n\nHighest USD BUY bank:");
        printBankExchangeRates(getBestBuyRatesBank(banksExchangeRates, CurrencyPair.USDUAH));

        // best USD SELL prices bank:
        System.out.println("\n\nLowest USD SELL bank:");
        printBankExchangeRates(getBestSellRatesBank(banksExchangeRates, CurrencyPair.USDUAH));
    }
}
