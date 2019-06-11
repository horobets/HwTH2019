package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieComparisonMode;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.List;
import java.util.Map;

public class ImdbTopMoviesDemo {
    public static void main(String[] args) {
        System.out.printf("%nIMDB Top 250 Movies Demo%n");


        ImdbTopMoviesCrawler moviesCrawler = new ImdbTopMoviesCrawler();

        List<ImdbMovieInfo> imdbTopMovies = moviesCrawler.getImdbTopMoviesDetails(250);

        ImdbTopMoviesAnalyzer moviesAnalyzer = new ImdbTopMoviesAnalyzer(imdbTopMovies);

        //sort by Title and print
        System.out.printf("%nSorted by Title: %n");
        ImdbMovieComparisonMode comparisonMode = ImdbMovieComparisonMode.TITLE;
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(comparisonMode));

        //sort by Release Year and print
        System.out.printf("%nSorted by Release Year: %n");
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.RELEASEDATE));

        //sort by Metascore and print
        System.out.printf("%nSorted by Metascore: %n");
        List<ImdbMovieInfo> metascoreSortedList = moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.METASCORE);
        PrintImdbMoviesList(metascoreSortedList);

        //Top Metascore ranked movie:
        System.out.printf("%nTop Metascore ranked movie: %n");
        PrintImdbMovie(metascoreSortedList.get(metascoreSortedList.size() - 1));

        //sort by running time and print
        System.out.printf("%nSorted by Running Time: %n");
        List<ImdbMovieInfo> runningTimeSortedList = moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.RUNNINGTIME);
        PrintImdbMoviesList(runningTimeSortedList);

        //shortest movie:
        System.out.printf("%nShortest movie: %n");
        PrintImdbMovie(runningTimeSortedList.get(0));

        //Directors and number of their movies:
        System.out.printf("%nDirectors and number of their movies: %n");
        PrintDirectors(moviesAnalyzer.getDirectorsInMovies());

        //Directors and average ratings:
        System.out.printf("%nDirectors and average ratings: %n");
        PrintDirectorsWithRatings(moviesAnalyzer.getDirectorsWithMoviesAverageRatings());

        System.out.printf("%nTotal Directors: %s %n", moviesAnalyzer.getAllDirectors().size());

        //Actors and number of their movies:
        System.out.printf("%nActors and number of their movies: %n");
        PrintActors(moviesAnalyzer.getActorsInMovies());

        System.out.printf("%nTotal Actors: %s %n", moviesAnalyzer.getAllActors().size());

        //Actors and average ratings:
        System.out.printf("%nActors and average ratings: %n");
        PrintActorsWithRatings(moviesAnalyzer.getActorsWithMoviesAverageRatings());

    }

    public static void PrintImdbMoviesList(List<ImdbMovieInfo> imdbMovies) {
        for (ImdbMovieInfo movieInfo : imdbMovies) {
            PrintImdbMovie(movieInfo);
        }
    }

    public static void PrintImdbMovie(ImdbMovieInfo imdbMovie) {

        System.out.printf("%s (%d) Metascore: %d, Running Time: %s min %n",
                imdbMovie.getMovieTitle(),
                imdbMovie.getReleaseDate().getYear(),
                imdbMovie.getRatingMetascore(),
                imdbMovie.getRunningTime().toMinutes());
    }

    public static void PrintActors(List<String> actors) {
        for (String actor : actors) {
            System.out.printf("Actor: %s %n", actor);
        }
    }

    public static void PrintActors(Map<String, Integer> actorsInMovies) {
        for (Map.Entry<String, Integer> entry : actorsInMovies.entrySet()) {
            System.out.printf("Actor: %s, found in %d movies %n", entry.getKey(), entry.getValue());
        }
    }


    public static void PrintDirectors(List<String> director) {
        for (String actor : director) {
            System.out.printf("Director: %s %n", actor);
        }
    }


    public static void PrintDirectors(Map<String, Integer> directorsInMovies) {
        for (Map.Entry<String, Integer> entry : directorsInMovies.entrySet()) {
            System.out.printf("Director: %s, found in %d movies %n", entry.getKey(), entry.getValue());
        }
    }

    public static void PrintDirectorsWithRatings(Map<String, Float> directorsWithAverageRatings) {
        for (Map.Entry<String, Float> entry : directorsWithAverageRatings.entrySet()) {
            System.out.printf("Director: %s, average movies rating: %.2f %n", entry.getKey(), entry.getValue());
        }
    }

    public static void PrintActorsWithRatings(Map<String, Float> actorsWithAverageRatings) {
        for (Map.Entry<String, Float> entry : actorsWithAverageRatings.entrySet()) {
            System.out.printf("Actor: %s, average movies rating: %.2f %n", entry.getKey(), entry.getValue());
        }
    }
}
