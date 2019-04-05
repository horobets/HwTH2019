package task3.shawshankredemption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ImdbMoviePage extends BasePage {
    public ImdbMoviePage(WebDriver driver) {
        super(driver);
    }

    By movieTitleBy = By.xpath("//div[@class='title_wrapper']/h1");
    By releaseDateBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/a[2]");
    By runningTimeBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/time");
    By ratingValBy = By.xpath("//span[@itemprop='ratingValue']");
    By genreBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/a[1]");
    By trailerLinkBy = By.xpath("//div[@class='slate']/a");
    By posterLinkBy = By.xpath("//div[@class='poster']/a");
    By directorNameBy = By.xpath("//div[@class='credit_summary_item']/a");
    By actorsBy = By.xpath("//*[@id='titleCast']//td[2]/a");
    By ratingMetascoreBy = By.xpath("//div[contains(@class,'metacriticScore')]/span");
    By userReviewsCountBy = By.xpath("//div[contains(@class, 'titleReviewbarItem')]//a[1]");
    By criticReviewsCountBy = By.xpath("//div[contains(@class, 'titleReviewbarItem')]//a[2]");
    By moviesLikeThisBy = By.xpath("//div[@class='rec_page rec_selected']//img[@title]");

    public void goToPage() {
        driver.get("https://www.imdb.com/title/tt0111161/");
    }

    public MovieInfo getMovieInfo() {
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.movieTitle = getMovieTitle();
        movieInfo.releaseDate = getReleaseDate();
        movieInfo.runningTime = getRunningTime();
        movieInfo.rating = getRating();
        movieInfo.genre = getGenre();
        movieInfo.trailerLink = getTrailerLink();
        movieInfo.posterLink = getPosterLink();
        movieInfo.directorName = getDirectorName();
        movieInfo.actors = getActorNames();
        movieInfo.ratingMetascore = getRatingMetascore();
        movieInfo.userReviewsCount = getUserReviewsCount();
        movieInfo.criticReviewsCount = getCriticsReviewsCount();
        movieInfo.moviesLikeThis = getMoviesLikeThis();

        return movieInfo;
    }

    String getMovieTitle() {
        return driver.findElement(movieTitleBy).getText();
    }

    Date getReleaseDate() {
        String releaseDateStr = driver.findElement(releaseDateBy).getText();
        Date releaseDate = null;
        try {
            DateFormat releaseDateStrFormat = new SimpleDateFormat("dd MMMM yyyy '(USA)'", Locale.US);

            releaseDate = releaseDateStrFormat.parse(releaseDateStr);
        } catch (ParseException ex) {
            System.out.printf("Error: Invalid ReleaseDate datetime format: %s\n", releaseDateStr);
        }
        return releaseDate;
    }

    Duration getRunningTime() {
        String runningTimeStr = driver.findElement(runningTimeBy).getAttribute("datetime");
        return java.time.Duration.parse(runningTimeStr);
    }

    float getRating() {
        return Float.parseFloat(driver.findElement(ratingValBy).getText());
    }

    Genre getGenre() {
        String genreStr = driver.findElement(genreBy).getText();
        return Genre.get(genreStr);
    }

    String getTrailerLink() {
        return driver.findElement(trailerLinkBy).getAttribute("href");
    }

    String getPosterLink() {
        return driver.findElement(posterLinkBy).getAttribute("href");
    }

    String getDirectorName() {
        return driver.findElement(directorNameBy).getText();
    }

    List<String> getActorNames() {
        List<WebElement> actorElements = driver.findElements(actorsBy);
        List<String> actorNames = new ArrayList<String>();
        for (WebElement actorElement : actorElements)
            actorNames.add(actorElement.getText());

        return actorNames;
    }

    int getRatingMetascore() {
        return Integer.parseInt(driver.findElement(ratingMetascoreBy).getText());
    }

    int getUserReviewsCount() {
        String userReviewsCountStr = driver.findElement(userReviewsCountBy).getText().replaceAll("\\D", "");
        return Integer.parseInt(userReviewsCountStr);
    }

    int getCriticsReviewsCount() {
        String criticReviewsStr = driver.findElement(criticReviewsCountBy).getText().replaceAll("\\D", "");
        return Integer.parseInt(criticReviewsStr);
    }

    List<String> getMoviesLikeThis() {
        List<WebElement> moviesLikeThisElements = driver.findElements(moviesLikeThisBy);
        List<String> moviesLikeThisNames = new ArrayList<String>();
        for (WebElement moviesLikeThisElement : moviesLikeThisElements)
            moviesLikeThisNames.add(moviesLikeThisElement.getAttribute("title"));

        return moviesLikeThisNames;
    }
}
