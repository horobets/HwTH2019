package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public class ImdbMovieReleaseDateComparator implements Comparator<ImdbMovieInfo> {
    @Override
    public int compare(ImdbMovieInfo o1, ImdbMovieInfo o2) {
        return o1.getReleaseDate().compareTo(o2.getReleaseDate());
    }
}
