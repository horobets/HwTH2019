package task14.imdbtopmovies;

import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;
import task14.imdbtopmovies.imdbparsers.HtmlDownloader;
import task14.imdbtopmovies.imdbparsers.ImdbMoviePageParser;
import task14.imdbtopmovies.imdbparsers.ImdbTopListItem;
import task14.imdbtopmovies.imdbparsers.ImdbTopListParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImdbTopMoviesCrawler {
    private final String imdbBaseLink = "https://www.imdb.com";
    private final String imdbTopMoviesLink = "https://www.imdb.com/chart/top";

    public List<ImdbMovieInfo> getImdbTopMoviesDetails() {

        //download and process the top 250 list page
        String topListPageSource;
        try {
            System.out.printf("%nDownloading page: %s", imdbTopMoviesLink);
            topListPageSource = HtmlDownloader.downloadHtml(imdbTopMoviesLink);
        } catch (IOException ex) {
            System.err.printf("Error getting imdb top movies page: %n %s", ex.getMessage());
            return null;
        }
        ImdbTopListParser topListParser = new ImdbTopListParser(topListPageSource);
        List<ImdbTopListItem> topListItems = topListParser.getImdbTopListItems();

        //process every movie page
        List<ImdbMovieInfo> imdbMovieInfos = new ArrayList<>();
        for (ImdbTopListItem topListItem : topListItems) {
            //compose url from domain name and relative link
            String movieLink = String.format("%s%s", imdbBaseLink, topListItem.getLink());

            imdbMovieInfos.add(parseMoviePage(movieLink));
        }
        return imdbMovieInfos;
    }

    private ImdbMovieInfo parseMoviePage(String moviePageLink) {

        String moviePagePageSource;
        try {
            System.out.printf("%nDownloading page: %s", moviePageLink);
            moviePagePageSource = HtmlDownloader.downloadHtml(moviePageLink);
        } catch (IOException ex) {
            System.err.printf("Error getting imdb movie page: %n %s", ex.getMessage());
            return null;
        }

        ImdbMoviePageParser moviePageParser = new ImdbMoviePageParser(moviePagePageSource);

        return moviePageParser.getMovieInfo();
    }
}
