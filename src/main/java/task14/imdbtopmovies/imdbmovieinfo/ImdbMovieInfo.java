package task14.imdbtopmovies.imdbmovieinfo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class ImdbMovieInfo {

        private String movieTitle;
        private LocalDate releaseDate;
        private Duration runningTime;
        private float rating;
        private List<Genre> genres;
        private String directorName;
        private List<String> actors;
        private int ratingMetascore;


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

        public String getMovieTitle() {
            return movieTitle;
        }

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        public Duration getRunningTime() {
            return runningTime;
        }

        public float getRating() {
            return rating;
        }

        public List<Genre> getGenres() {
            return genres;
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

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void setRunningTime(Duration runningTime) {
            this.runningTime = runningTime;
        }

        public void setRating(float rating) {
            this.rating = rating;
        }

        public void setGenres(List<Genre> genres) {
            this.genres = genres;
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

    }
