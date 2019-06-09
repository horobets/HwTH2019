package task14.imdbtopmovies.imdbparsers;

public class ImdbTopListItem implements Comparable {

    private String title;
    private double score;
    private int year;
    private String link;

    public ImdbTopListItem(String title, double score, int year, String link) {
        this.title = title;
        this.score = score;
        this.year = year;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public int getYear() {
        return year;
    }

    public String getLink() {
        return link;
    }

    @Override
    public int compareTo(Object o) {
        ImdbTopListItem m = (ImdbTopListItem) o;
        return (score < m.score) ? -1 : ((score == m.score) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "ImdbTopListItem{" +
                "title='" + title + '\'' +
                ", score=" + score +
                ", year=" + year +
                ", link='" + link + '\'' +
                '}';
    }
}
