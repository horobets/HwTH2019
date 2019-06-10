package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieComparisonMode;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.List;

public class ImdbTopMoviesDemo {
    public static void main(String[] args) {
        System.out.printf("%nIMDB Top 250 Movies Demo%n");


        ImdbTopMoviesCrawler moviesCrawler = new ImdbTopMoviesCrawler();

        List<ImdbMovieInfo> imdbTopMovies = moviesCrawler.getImdbTopMoviesDetails(5);

        ImdbTopMoviesAnalyzer moviesAnalyzer = new ImdbTopMoviesAnalyzer(imdbTopMovies);

        //sort by Title and print
        System.out.println("%nSorted by Title: ");
        ImdbMovieComparisonMode comparisonMode = ImdbMovieComparisonMode.TITLE;
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(comparisonMode));

        //sort by Release Year and print
        System.out.println("%nSorted by Release Year: ");
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.RELEASEDATE));

        //sort by Metascore and print
        System.out.println("%nSorted by Metascore: ");
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.METASCORE));

        //sort by running time and print
        System.out.println("%nSorted by Running Time: ");
        PrintImdbMoviesList(moviesAnalyzer.getSortedMoviesList(ImdbMovieComparisonMode.RUNNINGTIME));

    }

    public static void PrintImdbMoviesList(List<ImdbMovieInfo> imdbMovies) {
        for (ImdbMovieInfo movieInfo : imdbMovies) {
            System.out.printf("%s (%d) Metascore: %d, Running Time: %s %n",
                    movieInfo.getMovieTitle(),
                    movieInfo.getReleaseDate().getYear(),
                    movieInfo.getRatingMetascore(),
                    movieInfo.getRunningTime());
        }
    }
}
