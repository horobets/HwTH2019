package task3.shawshankredemption;

import java.util.HashMap;
import java.util.Map;

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

    // Reverse Lookup (ref: https://howtodoinjava.com/java/enum/java-enum-string-example/ )
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