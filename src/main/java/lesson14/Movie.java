package lesson14;

public class Movie implements Comparable {

    public String title;
    public double score;
    public int year;

    public Movie(String title, double score, int year) {
        this.title = title;
        this.score = score;
        this.year = year;
    }

    public Movie(String title, double score) {
        this(title, score, 0);
    }

    @Override
    public int compareTo(Object o) {
        Movie m = (Movie) o;
        return (score < m.score) ? -1 : ((score == m.score) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", score=" + score +
                ", year=" + year +
                '}';
    }
}
