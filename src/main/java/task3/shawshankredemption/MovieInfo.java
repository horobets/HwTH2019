package task3.shawshankredemption;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class MovieInfo {

    private String movieTitle;
    private Date releaseDate;
    private Duration runningTime;
    private float rating;
    private Genre genre;
    private String trailerLink;
    private String posterLink;
    private String directorName;
    private List<String> actors;
    private int ratingMetascore;
    private int userReviewsCount;
    private int criticReviewsCount;
    private List<String> moviesLikeThis;


    public int getRrunningTimeInMins() {
        return (int) runningTime.toMinutes();
    }

    public int getRrunningTimeInSec() {
        return (int) runningTime.getSeconds();
    }

    public List<String> getActors(int amount) {
        //return the requested number of items but no more that the List size
        int numberOfItemsToReturn = amount <= actors.size() ? amount : actors.size();
        return actors.subList(0, numberOfItemsToReturn);
    }

    public int getTotalReviewsCount() {
        return userReviewsCount + criticReviewsCount;
    }

    public List<String> getMoviesLikeThis(int amount) {
        int numberOfItemsToReturn = amount <= moviesLikeThis.size() ? amount : moviesLikeThis.size();
        return moviesLikeThis.subList(0, numberOfItemsToReturn);
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public float getRating() {
        return rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public String getDirectorName() {
        return directorName;
    }

    public List<String> getActors() {
        return actors;
    }

    public int getRatingMetascore() {
        return ratingMetascore;
    }

    public int getUserReviewsCount() {
        return userReviewsCount;
    }

    public int getCriticReviewsCount() {
        return criticReviewsCount;
    }

    public List<String> getMoviesLikeThis() {
        return moviesLikeThis;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setRatingMetascore(int ratingMetascore) {
        this.ratingMetascore = ratingMetascore;
    }

    public void setUserReviewsCount(int userReviewsCount) {
        this.userReviewsCount = userReviewsCount;
    }

    public void setCriticReviewsCount(int criticReviewsCount) {
        this.criticReviewsCount = criticReviewsCount;
    }

    public void setMoviesLikeThis(List<String> moviesLikeThis) {
        this.moviesLikeThis = moviesLikeThis;
    }
}