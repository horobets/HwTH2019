package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public class ImdbMovieMetascoreComparator implements Comparator<ImdbMovieInfo> {
    @Override
    public int compare(ImdbMovieInfo o1, ImdbMovieInfo o2) {
        return Float.compare(o1.getRatingMetascore(), o2.getRatingMetascore());
    }
}
