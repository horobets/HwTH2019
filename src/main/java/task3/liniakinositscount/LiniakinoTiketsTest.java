package task3.liniakinositscount;

import org.testng.annotations.Test;


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

        System.out.printf("Reserved Seats (%%): %.2f%%\n", seats.getPercentOfReservedSeats());
        System.out.printf("Free Seats (%%): %.2f%%\n", seats.getPercentOfFreeSeats());
    }
}