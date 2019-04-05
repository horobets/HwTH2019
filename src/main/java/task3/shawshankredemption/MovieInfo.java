package task3.shawshankredemption;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class MovieInfo {
    public String movieTitle;
    public Date releaseDate;
    public Duration runningTime;

    public int getRrunningTimeInMins() {
        return (int) runningTime.toMinutes();
    }

    public int getRrunningTimeInSec() {
        return (int) runningTime.getSeconds();
    }

    public float rating;
    public Genre genre;
    public String trailerLink;
    public String posterLink;
    public String directorName;
    public List<String> actors;

    public List<String> getActors(int amount) {
        //return the requested number of items but no more that the List size)
        int numberOfItemsToReturn = amount <= actors.size() ? amount : actors.size();
        return actors.subList(0, numberOfItemsToReturn);
    }

    public int ratingMetascore;
    public int userReviewsCount;
    public int criticReviewsCount;

    public int getTotalReviewsCount() {
        return userReviewsCount + criticReviewsCount;
    }

    public List<String> moviesLikeThis;

    public List<String> getMoviesLikeThis(int amount) {
        int numberOfItemsToReturn = amount <= moviesLikeThis.size() ? amount : moviesLikeThis.size();
        return moviesLikeThis.subList(0, numberOfItemsToReturn);
    }
}


