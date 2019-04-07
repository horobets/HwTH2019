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

    private By movieTitleBy = By.xpath("//div[@class='title_wrapper']/h1");
    private By releaseDateBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/a[2]");
    private By runningTimeBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/time");
    private By ratingValBy = By.xpath("//span[@itemprop='ratingValue']");
    private By genreBy = By.xpath("//div[@class='title_wrapper']/div[@class='subtext']/a[1]");
    private By trailerLinkBy = By.xpath("//div[@class='slate']/a");
    private By posterLinkBy = By.xpath("//div[@class='poster']/a");
    private By directorNameBy = By.xpath("//div[@class='credit_summary_item']/a");
    private By actorsBy = By.xpath("//*[@id='titleCast']//td[2]/a");
    private By ratingMetascoreBy = By.xpath("//div[contains(@class,'metacriticScore')]/span");
    private By userReviewsCountBy = By.xpath("//div[contains(@class, 'titleReviewbarItem')]//a[1]");
    private By criticReviewsCountBy = By.xpath("//div[contains(@class, 'titleReviewbarItem')]//a[2]");
    private By moviesLikeThisBy = By.xpath("//div[@class='rec_page rec_selected']//img[@title]");

    public void goToPage() {

        driver.get("https://www.imdb.com/title/tt0111161/");
    }

    public MovieInfo getFullMovieInfo() {

        MovieInfo movieInfo = new MovieInfo();

        movieInfo.setMovieTitle(getMovieTitle());
        movieInfo.setReleaseDate(getReleaseDate());
        movieInfo.setRunningTime(getRunningTime());
        movieInfo.setRating(getRating());
        movieInfo.setGenre(getGenre());
        movieInfo.setTrailerLink(getTrailerLink());
        movieInfo.setPosterLink(getPosterLink());
        movieInfo.setDirectorName(getDirectorName());
        movieInfo.setActors(getActorNames());
        movieInfo.setRatingMetascore(getRatingMetascore());
        movieInfo.setUserReviewsCount(getUserReviewsCount());
        movieInfo.setCriticReviewsCount(getCriticsReviewsCount());
        movieInfo.setMoviesLikeThis(getMoviesLikeThis());

        return movieInfo;
    }

    public String getMovieTitle() {

        return driver.findElement(movieTitleBy).getText();
    }

    public Date getReleaseDate() {
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

    public Duration getRunningTime() {
        String runningTimeStr = driver.findElement(runningTimeBy).getAttribute("datetime");
        return java.time.Duration.parse(runningTimeStr);
    }

    public float getRating() {

        return Float.parseFloat(driver.findElement(ratingValBy).getText());
    }

    public Genre getGenre() {
        String genreStr = driver.findElement(genreBy).getText();
        return Genre.get(genreStr);
    }

    public String getTrailerLink() {

        return driver.findElement(trailerLinkBy).getAttribute("href");
    }

    public String getPosterLink() {

        return driver.findElement(posterLinkBy).getAttribute("href");
    }

    public String getDirectorName() {

        return driver.findElement(directorNameBy).getText();
    }

    public List<String> getActorNames() {
        List<WebElement> actorElements = driver.findElements(actorsBy);
        List<String> actorNames = new ArrayList<String>();
        for (WebElement actorElement : actorElements) {
            actorNames.add(actorElement.getText());
        }

        return actorNames;
    }

    public int getRatingMetascore() {
        return Integer.parseInt(driver.findElement(ratingMetascoreBy).getText());
    }

    public int getUserReviewsCount() {
        String userReviewsCountStr = driver.findElement(userReviewsCountBy).getText().replaceAll("\\D", "");
        return Integer.parseInt(userReviewsCountStr);
    }

    public int getCriticsReviewsCount() {
        String criticReviewsStr = driver.findElement(criticReviewsCountBy).getText().replaceAll("\\D", "");
        return Integer.parseInt(criticReviewsStr);
    }

    public List<String> getMoviesLikeThis() {
        List<WebElement> moviesLikeThisElements = driver.findElements(moviesLikeThisBy);
        List<String> moviesLikeThisNames = new ArrayList<String>();
        for (WebElement moviesLikeThisElement : moviesLikeThisElements) {
            moviesLikeThisNames.add(moviesLikeThisElement.getAttribute("title"));
        }

        return moviesLikeThisNames;
    }
}
