package task3.currency;

import org.testng.annotations.Test;
import task3.currency.pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesTest extends BaseTest {
    @Test
    public void printExchangeRatesInfo() {

        BankCurrencyInfoBasePage bankPage = new PrivatbankCurrencyPage(driver);
        bankPage.goToPage();

        List<BankExchangeRatesInfo> banksExchangeRates = new ArrayList<>();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        bankPage = new UkrsibbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        bankPage = new UniversalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        bankPage = new OschadbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());

        bankPage = new NationalbankCurrencyPage(driver);
        bankPage.goToPage();
        banksExchangeRates.add(bankPage.getBankExchangeRates());


        // output Banks Exchange Rates
        for(BankExchangeRatesInfo bankExchangeRates : banksExchangeRates)
        {
            printBankExchangeRates(bankExchangeRates);
        }

        // calculate and output average rates
        printAverageRates(banksExchangeRates);

    }

    private void printBankExchangeRates(BankExchangeRatesInfo bankExchangeRates)
    {
        System.out.printf("\nBank: %s\n", bankExchangeRates.getBankName());
        System.out.printf("Website: %s\n", bankExchangeRates.getBankUrl());
        System.out.println("Exchange Rates:");
        for(Map.Entry<CurrencyPair, PricePair> exchangeRate : bankExchangeRates.getExchangeRates().entrySet())
        {
            System.out.printf("Currency: %s BUY: %.2f SELL: %.2f\n", exchangeRate.getKey(), exchangeRate.getValue().getBidPrice(), exchangeRate.getValue().getAskPrice());
        }
    }
    private BankExchangeRatesInfo getBestExchangeRatesBank(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair, boolean bidPrice) {
/*
        //find highest bid price
        double highestBidPrice = 0;
        //BankExchangeRatesInfo bankWithBestExchangePrice = banksExchangeRates.get(0).getExchangeRates().;
        for (BankExchangeRatesInfo bankRates : banksExchangeRates) {
            for (CurrencyInfo rate : bankRates.getExchangeRates()) {
                if (rate.getCurrencyPair().equals(currencyPair)) {
                    if(highestBidPrice < rate.getBidPrice()) {
                        highestBidPrice = rate.getBidPrice();
                    }
                }
            }
        }*/
        return null;
    }
    private void printAverageRates(List<BankExchangeRatesInfo> banksExchangeRates) {

        // calc average USD buy price
        double averageUsdBuyRate = getAverageRate(banksExchangeRates, CurrencyPair.USDUAH, true);
        // calc average USD sell price
        double averageUsdSellRate = getAverageRate(banksExchangeRates, CurrencyPair.USDUAH, false);

        // calc average EUR buy price
        double averageEurBuyRate = getAverageRate(banksExchangeRates, CurrencyPair.EURUAH, true);
        // calc average EUR sell price
        double averageEurSellRate = getAverageRate(banksExchangeRates, CurrencyPair.EURUAH, false);

        System.out.println("\nAverage Rates:");
        System.out.printf("Average USD Rate: BUY: %s, SELL: %s \n", averageUsdBuyRate, averageUsdSellRate);
        System.out.printf("Average EUR Rate: BUY: %s, SELL: %s \n", averageEurBuyRate, averageEurSellRate);
    }

    private double getAverageRate(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair, boolean bidPrice) {
        double ratesSum = 0;
        for (BankExchangeRatesInfo bankRates : banksExchangeRates) {
            if(bidPrice) {
                ratesSum += bankRates.getExchangeRates().get(currencyPair).getBidPrice();
            }
            else {
                ratesSum += bankRates.getExchangeRates().get(currencyPair).getAskPrice();
            }
        }
        return ratesSum / banksExchangeRates.size();
    }
    /*public BankExchangeRatesInfo getExchangeRateInfo(BankCurrencyInfoBasePage bankCurrencyInfoPage)
    {
        bankCurrencyInfoPage.goToPage();
        return bankCurrencyInfoPage.getBankExchangeRates();
    }*/
}
