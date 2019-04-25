package task3.currency;

import org.testng.annotations.Test;
import task3.currency.pages.*;
import task3.currency.pages.parsing.OschadbankCurrencyPageParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesTest extends BaseTest {


    @Test
    public void printExchangeRatesInfo() {

        List<BankExchangeRatesInfo> banksExchangeRates = new ArrayList<>();

        // get Privatbank rates
        BankCurrencyInfoBasePage bankPage = new PrivatbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Ukrsibbank rates
        bankPage = new UkrsibbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Universalbank rates
        bankPage = new UniversalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Oschadbank rates
        bankPage = new OschadbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // get Nationalbank rates
        bankPage = new NationalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        // output all Banks exchange Rates
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

    protected void printBankExchangeRates(BankExchangeRatesInfo bankExchangeRates) {
        System.out.printf("\nBank: %s\n", bankExchangeRates.getBankName());
        System.out.printf("Website: %s\n", bankExchangeRates.getBankUrl());
        System.out.println("Exchange Rates:");
        for (Map.Entry<CurrencyPair, PricePair> exchangeRate : bankExchangeRates.getExchangeRates().entrySet()) {
            System.out.printf("Currency: %s BUY: %.2f SELL: %.2f\n", exchangeRate.getKey(), exchangeRate.getValue().getBidPrice(), exchangeRate.getValue().getAskPrice());
        }
    }

    protected BankExchangeRatesInfo getBestBuyRatesBank(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair) {

        //find the highest bid price
        BankExchangeRatesInfo bankWithPestRate = banksExchangeRates.get(0);//set to the first by default
        for (BankExchangeRatesInfo currentBankRates : banksExchangeRates) {
            if (bankWithPestRate.getExchangeRates().get(currencyPair).getBidPrice() < currentBankRates.getExchangeRates().get(currencyPair).getBidPrice()) {
                bankWithPestRate = currentBankRates;
            }
        }
        return bankWithPestRate;
    }

    protected BankExchangeRatesInfo getBestSellRatesBank(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair) {

        //find the lowest sell price
        BankExchangeRatesInfo bankWithPestRate = banksExchangeRates.get(0);//set to the first by default
        for (BankExchangeRatesInfo currentBankRates : banksExchangeRates) {
            if (bankWithPestRate.getExchangeRates().get(currencyPair).getAskPrice() > currentBankRates.getExchangeRates().get(currencyPair).getAskPrice()) {
                bankWithPestRate = currentBankRates;
            }
        }
        return bankWithPestRate;
    }

    protected void printAverageRates(List<BankExchangeRatesInfo> banksExchangeRates) {

        // calc average USD buy price
        double averageUsdBuyRate = getAverageRate(banksExchangeRates, CurrencyPair.USDUAH, true);
        // calc average USD sell price
        double averageUsdSellRate = getAverageRate(banksExchangeRates, CurrencyPair.USDUAH, false);

        // calc average EUR buy price
        double averageEurBuyRate = getAverageRate(banksExchangeRates, CurrencyPair.EURUAH, true);
        // calc average EUR sell price
        double averageEurSellRate = getAverageRate(banksExchangeRates, CurrencyPair.EURUAH, false);

        System.out.println("\nAverage Rates:");
        System.out.printf("Average USD Rate: BUY: %.2f, SELL: %.2f \n", averageUsdBuyRate, averageUsdSellRate);
        System.out.printf("Average EUR Rate: BUY: %.2f, SELL: %.2f \n", averageEurBuyRate, averageEurSellRate);
    }

    private double getAverageRate(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair, boolean bidPrice) {
        double ratesSum = 0;
        for (BankExchangeRatesInfo bankRates : banksExchangeRates) {
            if (bidPrice) {
                ratesSum += bankRates.getExchangeRates().get(currencyPair).getBidPrice();
            } else {
                ratesSum += bankRates.getExchangeRates().get(currencyPair).getAskPrice();
            }
        }
        return ratesSum / banksExchangeRates.size();
    }
}