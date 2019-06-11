package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public enum ImdbMovieComparisonMode {
    TITLE(new ImdbMovieTitleComparator()),
    RATING(new ImdbMovieRatingComparator()),
    RELEASEDATE(new ImdbMovieReleaseDateComparator()),
    RUNNINGTIME(new ImdbMovieRunningTimeComparator()),
    METASCORE(new ImdbMovieMetascoreComparator());
    private Object comparatorclass;

    ImdbMovieComparisonMode(Object comparatorclass) {
        this.comparatorclass = comparatorclass;
    }

    public <T extends Comparator<ImdbMovieInfo>> T getComparator() {
        if (comparatorclass == null) {
            throw new NullPointerException();
        }
        return (T) comparatorclass;
    }
}
