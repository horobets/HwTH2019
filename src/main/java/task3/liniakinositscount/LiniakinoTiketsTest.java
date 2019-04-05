package task3.liniakinositscount;

import org.testng.annotations.Test;

import java.text.NumberFormat;

public class LiniakinoTiketsTest extends BaseTest {

    @Test
    public void printTiketsInfo() {

        MovieListPage moviePage = new MovieListPage(driver);
        moviePage.goToPage();

        TiketsOrderPopup orderPopup = moviePage.openOrderPage();

        SeatsInfo seats = orderPopup.getSeatsInfoOfLatestShowtime();

        System.out.printf("Total Seats: %d\n", seats.getTotalSeatsCount());
        System.out.printf("Reserved Seats: %d\n", seats.getReservedSeatsCount());
        System.out.printf("Free Seats: %d\n", seats.getFreeSeatsCount());

        NumberFormat formatAsPercent = NumberFormat.getPercentInstance();
        System.out.printf("Reserved Seats (%): %s\n", formatAsPercent.format(seats.getPercentOfReservedSeats()));
        System.out.printf("Free Seats (%): %s\n", formatAsPercent.format(seats.getPercentOfFreeSeats()));

    }
}