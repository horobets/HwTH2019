package task3.shawshankredemption;

import org.testng.annotations.Test;
import java.text.DateFormat;

public class ImdbMovieInfoTest extends BaseTest {

    @Test
    public void printMovieInfo() {

        ImdbMoviePage moviePage = new ImdbMoviePage(driver);
        moviePage.goToPage();

        MovieInfo movieInfo = moviePage.getMovieInfo();

        System.out.printf("Movie: %s\n", movieInfo.movieTitle);

        String formattedReleaseDate = DateFormat.getDateInstance().format(movieInfo.releaseDate);
        System.out.printf("Release date: %s\n", formattedReleaseDate);

        System.out.printf("Running Time: %s minutes\n", movieInfo.getRrunningTimeInMins());
        System.out.printf("Running Time: %s seconds\n", movieInfo.getRrunningTimeInSec());
        System.out.printf("Rating: %s\n", movieInfo.rating);
        System.out.printf("Genre: %s\n", movieInfo.genre);
        System.out.printf("Trailer: %s\n", movieInfo.trailerLink);
        System.out.printf("Poster: %s\n", movieInfo.posterLink);
        System.out.printf("Director: %s\n", movieInfo.directorName);

        System.out.println("Top 5 Actors:");
        for (String actorName : movieInfo.getActors(5)) {
            System.out.printf(" - %s\n", actorName);
        }

        System.out.printf("Metascore rating: %s\n", movieInfo.ratingMetascore);

        System.out.printf("User Reviews: %s\n", movieInfo.userReviewsCount);
        System.out.printf("Critic Reviews: %s\n", movieInfo.criticReviewsCount);
        System.out.printf("Total Reviews: %s\n", movieInfo.getTotalReviewsCount());

        System.out.println("3 movies like this:");
        for (String movieName : movieInfo.getMoviesLikeThis(3)) {
            System.out.printf(" - %s\n", movieName);
        }
    }
}