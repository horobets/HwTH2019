package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieComparisonMode;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.*;

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

    public List<ImdbMovieInfo> getMoviesWithActor(String actor) {

        List<ImdbMovieInfo> moviesWithActor = new ArrayList<>();

        for (ImdbMovieInfo movieInfo : imdbTopMovies) {
            if (movieInfo.getActors().contains(actor)) {
                moviesWithActor.add(movieInfo);
            }
        }
        return moviesWithActor;
    }

    public List<String> getAllActors() {

        //use Set to avoid duplicates
        Set<String> actors = new HashSet<>();

        for (ImdbMovieInfo movieInfo : imdbTopMovies) {
            actors.addAll(movieInfo.getActors());
        }
        return new ArrayList<>(actors);
    }

    public Map<String, Integer> getActorsInMovies() {

        //use Set to avoid duplicates
        Map<String, Integer> actorsInMovies = new HashMap<>();

        for (String actor : getAllActors()) {
            actorsInMovies.put(actor, getMoviesWithActor(actor).size());
        }
        return actorsInMovies;
    }

    public List<String> getAllDirectors() {

        //use Set to avoid duplicates
        Set<String> directors = new HashSet<>();

        for (ImdbMovieInfo movieInfo : imdbTopMovies) {
            directors.add(movieInfo.getDirectorName());
        }
        return new ArrayList<>(directors);
    }
}
