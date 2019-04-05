package task3.shawshankredemption;

import java.util.HashMap;
import java.util.Map;

//https://howtodoinjava.com/java/enum/java-enum-string-example/
public enum Genre {
    HORROR("Horror"),
    BIOGRAPHY("Biography"),
    COMEDY("Comedy"),
    DRAMA("Drama");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    // Reverse Lookup
    private static final Map<String, Genre> lookup = new HashMap<String, Genre>();

    //Populate the lookup table on loading time
    static {
        for (Genre genre : Genre.values()) {
            lookup.put(genre.toString(), genre);
        }
    }

    //This method can be used for reverse lookup purpose
    public static Genre get(String description) {
        return lookup.get(description);
    }
}


/*
Drama (1,555,713)
Romance (479,606)
Comedy (227,574)
Short (213,565)
Crime (156,360)
Mystery (103,783)
Thriller (103,090)
Family (94,265)
Action (89,220)
Fantasy (60,669)
Adventure (54,977)
Sci-Fi (40,433)
Animation (34,472)
History (31,227)
Horror (27,514)
Music (22,592)
War (22,127)
Documentary (17,794)
Biography (17,782)
Musical (16,218)
Sport (9,629)
Reality-TV (9,167)
Talk-Show (7,485)
Western (6,563)
News (2,062)
Game-Show (981)
Film-Noir (702)
Adult (3)
 */