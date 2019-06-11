package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieComparisonMode;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<ImdbMovieInfo> getMoviesWithDirector(String director) {

        List<ImdbMovieInfo> moviesWithDirector = new ArrayList<>();

        for (ImdbMovieInfo movieInfo : imdbTopMovies) {
            if (movieInfo.getDirectorName().equals(director)) {
                moviesWithDirector.add(movieInfo);
            }
        }
        return moviesWithDirector;
    }

    public List<String> getAllActors() {

        //use Set to avoid duplicates
        Set<String> actors = new HashSet<>();

        for (ImdbMovieInfo movieInfo : imdbTopMovies) {
            actors.addAll(movieInfo.getActors());
        }
        return new ArrayList<>(actors);
    }


    public Map<String, Integer> getDirectorsInMovies() {

        Map<String, Integer> directorsInMovies = new HashMap<>();

        for (String director : getAllDirectors()) {
            directorsInMovies.put(director, getMoviesWithDirector(director).size());
        }
        return directorsInMovies;
    }



    public Map<String, Integer> getActorsInMovies() {

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

    public float getDirectorMoviesAverageRating(String director) {
        float ratingsSum = 0;
        List<ImdbMovieInfo> moviesWithDirector = getMoviesWithDirector(director);
        for (ImdbMovieInfo movieInfo : moviesWithDirector) {
            ratingsSum += movieInfo.getRating();
        }

        return ratingsSum / moviesWithDirector.size();
    }

    public float getActorMoviesAverageRating(String actor) {
        float ratingsSum = 0;
        List<ImdbMovieInfo> moviesWithActor = getMoviesWithActor(actor);
        for (ImdbMovieInfo movieInfo : moviesWithActor) {
            ratingsSum += movieInfo.getRating();
        }

        return ratingsSum / moviesWithActor.size();
    }

    public Map<String, Float> getDirectorsWithMoviesAverageRatings() {

        Map<String, Float> directorWithAverageRatings = new HashMap<>();

        for (String director : getAllDirectors()) {
            directorWithAverageRatings.put(director, getDirectorMoviesAverageRating(director));
        }

        Map<String, Float> directorWithAverageRatingsSortedByRatings = directorWithAverageRatings.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return directorWithAverageRatingsSortedByRatings;
    }

    public Map<String, Float> getActorsWithMoviesAverageRatings() {

        Map<String, Float> actorWithAverageRatings = new HashMap<>();

        for (String actor : getAllActors()) {
            actorWithAverageRatings.put(actor, getActorMoviesAverageRating(actor));
        }

        Map<String, Float> actorWithAverageRatingsSortedByRatings = actorWithAverageRatings.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return actorWithAverageRatingsSortedByRatings;
    }

}
