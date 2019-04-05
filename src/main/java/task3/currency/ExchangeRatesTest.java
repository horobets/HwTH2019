package task3.currency;

import org.testng.annotations.Test;
import task3.currency.pages.*;

import java.util.ArrayList;
import java.util.List;

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


        // calculate and output average rates
        printAverageRates(banksExchangeRates);


    }

    private BankExchangeRatesInfo getBestExchangeRatesBank(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair, boolean bidPrice) {

        //find highest bid price
        double highestBidPrice = 0;
        BankExchangeRatesInfo bankWithBestExchangePrice = banksExchangeRates.get(0).getExchangeRates().;
        for (BankExchangeRatesInfo bankRates : banksExchangeRates) {
            for (CurrencyInfo rate : bankRates.getExchangeRates()) {
                if (rate.getCurrencyPair().equals(currencyPair)) {
                    if(highestBidPrice < rate.getBidPrice()) {
                        highestBidPrice = rate.getBidPrice();
                    }
                }
            }
        }
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

        System.out.println("Average Rates:");
        System.out.printf("Average USD Rate: BUY: %s, SELL: %s \n", averageUsdBuyRate, averageUsdSellRate);
        System.out.printf("Average EUR Rate: BUY: %s, SELL: %s \n", averageEurBuyRate, averageEurSellRate);
    }

    private double getAverageRate(List<BankExchangeRatesInfo> banksExchangeRates, CurrencyPair currencyPair, boolean bidPrice) {
        double ratesSum = 0;
        for (BankExchangeRatesInfo bankRates : banksExchangeRates) {
            for (CurrencyInfo rate : bankRates.getExchangeRates()) {
                if (rate.getCurrencyPair().equals(currencyPair)) {
                    ratesSum += bidPrice ? rate.getBidPrice() : rate.getAskPrice();
                }
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
