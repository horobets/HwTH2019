package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public class ImdbMovieRatingComparator implements Comparator<ImdbMovieInfo> {
    @Override
    public int compare(ImdbMovieInfo o1, ImdbMovieInfo o2) {
        return Float.compare(o1.getRating(), o2.getRating());
    }
}
