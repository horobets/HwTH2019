package task14.imdbtopmovies.imdbparsers;

public abstract class ImdbParser {
    protected String imdbPageSource;

    public ImdbParser(String imdbPageSource) {
        this.imdbPageSource = imdbPageSource;
    }

}
