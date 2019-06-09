package task14.imdbtopmovies.imdbparsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImdbTopListParser extends ImdbParser {
    public ImdbTopListParser(String imdbPageSource) {
        super(imdbPageSource);
    }

    public List<ImdbTopListItem> getImdbTopListItems() {

        List<ImdbTopListItem> movies = new ArrayList<>();

        Document document = Jsoup.parse(imdbPageSource);
        Elements elements = document.select(".lister-list tr");
        for (Element element : elements) {
            String title = element.select(".titleColumn a").text();
            double score = Double.parseDouble(element.select(".imdbRating strong").text());
            int year = Integer.parseInt(element.select(".secondaryInfo").text()
                    .replace("(", "")
                    .replace(")", ""));

            String link = element.select(".titleColumn a").attr("href");
            movies.add(new ImdbTopListItem(title, score, year, link));
            //System.out.println(title+":"+score+":"+year);
        }

        return movies;
    }
}
