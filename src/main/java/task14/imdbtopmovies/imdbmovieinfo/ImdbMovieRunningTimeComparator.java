package task14.imdbtopmovies.imdbmovieinfo;

import java.util.Comparator;

public class ImdbMovieRunningTimeComparator implements Comparator<ImdbMovieInfo> {
    @Override
    public int compare(ImdbMovieInfo o1, ImdbMovieInfo o2) {
        return o1.getRunningTime().compareTo(o2.getRunningTime());
    }
}
