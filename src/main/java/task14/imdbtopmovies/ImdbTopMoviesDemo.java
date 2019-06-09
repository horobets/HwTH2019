package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.List;

public class ImdbTopMoviesDemo {
    public static void main(String[] args) {
        System.out.printf("%nIMDB Top 250 Movies Demo%n");


        ImdbTopMoviesCrawler moviesCrawler = new ImdbTopMoviesCrawler();

        List<ImdbMovieInfo> imdbTopMovies = moviesCrawler.getImdbTopMoviesDetails();

        ImdbTopMoviesAnalyzer moviesAnalyzer = new ImdbTopMoviesAnalyzer(imdbTopMovies);

    }
}
