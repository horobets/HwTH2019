package task3.shawshankredemption;

import org.testng.annotations.Test;

import java.text.DateFormat;

public class ImdbMovieInfoTest extends BaseTest {

    @Test
    public void printMovieInfoTest() {

        ImdbMoviePage moviePage = new ImdbMoviePage(driver);
        moviePage.goToPage();

        // Get full movie information
        MovieInfo movieInfo = moviePage.getFullMovieInfo();

        // Output movie information
        outputMovieInfo(movieInfo);

    }

    public void outputMovieInfo(MovieInfo movieInfo) {

        System.out.printf("Movie: %s\n", movieInfo.getMovieTitle());

        String formattedReleaseDate = DateFormat.getDateInstance().format(movieInfo.getReleaseDate());
        System.out.printf("Release date: %s\n", formattedReleaseDate);

        System.out.printf("Running Time: %s minutes\n", movieInfo.getRrunningTimeInMins());
        System.out.printf("Running Time: %s seconds\n", movieInfo.getRrunningTimeInSec());
        System.out.printf("Rating: %s\n", movieInfo.getRating());
        System.out.printf("Genre: %s\n", movieInfo.getGenre());
        System.out.printf("Trailer: %s\n", movieInfo.getTrailerLink());
        System.out.printf("Poster: %s\n", movieInfo.getPosterLink());
        System.out.printf("Director: %s\n", movieInfo.getDirectorName());

        System.out.println("Top 5 Actors:");
        for (String actorName : movieInfo.getActors(5)) {
            System.out.printf(" - %s\n", actorName);
        }

        System.out.printf("Metascore rating: %s\n", movieInfo.getRatingMetascore());

        System.out.printf("User Reviews: %s\n", movieInfo.getUserReviewsCount());
        System.out.printf("Critic Reviews: %s\n", movieInfo.getCriticReviewsCount());
        System.out.printf("Total Reviews: %s\n", movieInfo.getTotalReviewsCount());

        System.out.println("3 movies like this:");
        for (String movieName : movieInfo.getMoviesLikeThis(3)) {
            System.out.printf(" - %s\n", movieName);
        }
    }
}