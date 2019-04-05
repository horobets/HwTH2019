package task3.currency;

public class CurrencyInfo {
    public CurrencyInfo(double bidPrice, double askPrice, CurrencyPair currencyPair) {
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.currencyPair = currencyPair;
    }

    private double bidPrice;
    private double askPrice;
    private CurrencyPair currencyPair;

    public double getBidPrice() {
        return bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }
}