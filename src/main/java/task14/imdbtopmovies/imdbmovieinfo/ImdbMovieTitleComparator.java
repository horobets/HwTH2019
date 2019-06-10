package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public class ImdbMovieTitleComparator implements Comparator<ImdbMovieInfo> {
    @Override
    public int compare(ImdbMovieInfo o1, ImdbMovieInfo o2) {
        return o1.getMovieTitle().compareToIgnoreCase(o2.getMovieTitle());
    }
}
