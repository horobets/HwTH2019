package task14.imdbtopmovies.imdbparsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import task14.imdbtopmovies.imdbmovieinfo.Genre;
import task14.imdbtopmovies.imdbmovieinfo.ImdbMovieInfo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImdbMoviePageParser extends ImdbParser {

    private String movieTitleCss = ".title_wrapper > h1";
    private String releaseDateCss = ".subtext > a:last-of-type";
    private String runningTimeCss = ".subtext > time";
    private String ratingCss = "[itemprop='ratingValue']";
    private String genresCss = ".subtext > a[href*='genres=']";//list
    private String directorNameCss = ".credit_summary_item > a";//use first located item
    private String actorsCss = "#titleCast td:nth-of-type(2) > a";
    private String ratingMetascoreCss = "div[class~=metacriticScore] > span";


    public ImdbMoviePageParser(String imdbPageSource) {
        super(imdbPageSource);
    }

    public ImdbMovieInfo getMovieInfo() {

        ImdbMovieInfo movieInfo = new ImdbMovieInfo();

        movieInfo.setMovieTitle(parseTitle());
        movieInfo.setReleaseDate(parseReleaseDate());
        movieInfo.setRunningTime(parseRunningTime());
        movieInfo.setRating(parseRating());
        movieInfo.setGenres(parseGenres());
        movieInfo.setDirectorName(parseDirectorName());
        movieInfo.setActors(parseActorNames());
        movieInfo.setRatingMetascore(getRatingMetascore());

        return movieInfo;
    }

    private String parseTitle() {
        Document document = Jsoup.parse(imdbPageSource);
        //String title = document.select(movieTitleCss).text();
        String title = document.select(movieTitleCss).get(0).ownText();//exclude children from .text(), ref: https://stackoverflow.com/questions/13424816/jsoup-exclude-children-from-text
        return title;
    }

    private LocalDate parseReleaseDate() {

        Document document = Jsoup.parse(imdbPageSource);
        String releaseDateStr = document.select(releaseDateCss).get(0).ownText();

        String releaseDateStrNoCountry = releaseDateStr.substring(0, releaseDateStr.indexOf('(') - 1);//remove '(USA)' from '14 October 1994 (USA)'

        LocalDate releaseDate = null;

        //https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
        //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[d ]MMMM yyyy" /*"d MMMM yyyy"*/ /*"d MMMM yyyy '(USA)'"*/ /*"M/d/yyyy"*/);

        try {
            releaseDate = LocalDate.parse(releaseDateStrNoCountry, formatter);
        } catch (java.time.format.DateTimeParseException ex) {
            System.out.printf("Can't parse release date: %s%nParsing release year only", releaseDateStrNoCountry);
        }

        //if failed to p[arse full date - parse only year
        if (releaseDate == null) {
            //parsing year
            String releaseYearStr = RegexMatches.getRegexMatches(releaseDateStrNoCountry, "\\d{4}$").get(0);

            int releaseYear = Integer.valueOf(releaseYearStr);

            releaseDate = LocalDate.of(releaseYear, Month.JANUARY, 1);
        }

        return releaseDate;
    }

    private Duration parseRunningTime() {
        Document document = Jsoup.parse(imdbPageSource);
        String runningTimeStr = document.select(runningTimeCss).attr("datetime");
        return java.time.Duration.parse(runningTimeStr);
    }

    private float parseRating() {
        Document document = Jsoup.parse(imdbPageSource);
        String ratingStr = document.select(ratingCss).text();
        if (ratingStr.length() < 1)
            return 0;
        return Float.parseFloat(ratingStr);
    }

    private List<Genre> parseGenres() {
        Document document = Jsoup.parse(imdbPageSource);
        Elements elements = document.select(genresCss);

        List<Genre> genres = new ArrayList<>();
        for (Element element : elements) {
            String genreStr = element.text();
            genres.add(Genre.get(genreStr));
        }
        return genres;
    }

    private String parseDirectorName() {
        Document document = Jsoup.parse(imdbPageSource);
        String directorName = document.select(directorNameCss).get(0).text();
        return directorName;
    }

    private List<String> parseActorNames() {

        Document document = Jsoup.parse(imdbPageSource);
        Elements elements = document.select(actorsCss);

        List<String> actorNames = new ArrayList<>();
        for (Element element : elements) {
            String actorName = element.text();
            actorNames.add(actorName);
        }
        return actorNames;
    }

    private int getRatingMetascore() {
        Document document = Jsoup.parse(imdbPageSource);
        String RatingMetascoreStr = document.select(ratingMetascoreCss).text();

        if (RatingMetascoreStr.length() < 1)
            return 0;

        return Integer.parseInt(RatingMetascoreStr);
    }
}