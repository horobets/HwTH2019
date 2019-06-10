package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieComparisonMode;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.ArrayList;
import java.util.List;

public class ImdbTopMoviesAnalyzer {
    private List<ImdbMovieInfo> imdbTopMovies;

    public ImdbTopMoviesAnalyzer(List<ImdbMovieInfo> imdbTopMovies) {
        this.imdbTopMovies = imdbTopMovies;
    }

    public List<ImdbMovieInfo> getSortedMoviesList(ImdbMovieComparisonMode comparisonMode) {
        List<ImdbMovieInfo> newMoviesList = new ArrayList<>(imdbTopMovies);

        newMoviesList.sort(comparisonMode.getComparator());
        return newMoviesList;
    }
}
