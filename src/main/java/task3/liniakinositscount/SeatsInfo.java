package task3.liniakinositscount;

public class SeatsInfo {
    public SeatsInfo(int numberOfFreeSeats, int numberOfReserverdSeats) {
        freeSeatsCount = numberOfFreeSeats;
        reservedSeatsCount = numberOfReserverdSeats;
    }

    private int freeSeatsCount;

    public int getFreeSeatsCount() {
        return freeSeatsCount;
    }

    private int reservedSeatsCount;

    public int getReservedSeatsCount() {
        return reservedSeatsCount;
    }

    public int getTotalSeatsCount() {
        return freeSeatsCount + reservedSeatsCount;
    }
    public double getPercentOfFreeSeats(){

        return freeSeatsCount/getTotalSeatsCount();
    }
    public double getPercentOfReservedSeats()
    {
        return reservedSeatsCount/getTotalSeatsCount();
    }
}