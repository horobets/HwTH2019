package lesson14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("z", 2.4));
        movies.add(new Movie("Ab", 1.24));
        movies.add(new Movie("Ac", 4.4));
        movies.add(new Movie("D", 2.1));
        movies.add(new Movie("J", 4.4));


        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("Sorting...");
        Collections.sort(movies);

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
