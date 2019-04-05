package task3.currency;

public class PricePair {
    public PricePair(double bidPrice, double askPrice) {
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    private double bidPrice;
    private double askPrice;

    public double getBidPrice() {
        return bidPrice;
    }
    public double getAskPrice() {
        return askPrice;
    }
}
