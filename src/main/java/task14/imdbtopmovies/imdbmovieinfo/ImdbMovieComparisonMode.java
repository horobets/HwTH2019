package task14.imdbtopmovies.imdbmovieinfo;

public enum ImdbMovieComparisonMode {
    TITLE(ImdbMovieTitleComparator.class),
    RATING(ImdbMovieRatingComparator.class),
    RELEASEDATE(ImdbMovieReleaseDateComparator.class),
    RUNNINGTIME(ImdbMovieRunningTimeComparator.class),
    METASCORE(ImdbMovieMetascoreComparator.class);
    private Object comparatorclass;

    ImdbMovieComparisonMode(Object comparatorclass) {
        this.comparatorclass = comparatorclass;
    }

    public <T extends Object> T getComparator() {
        if (comparatorclass == null) {
            throw new NullPointerException();
        }
        return (T) comparatorclass;
    }
}
