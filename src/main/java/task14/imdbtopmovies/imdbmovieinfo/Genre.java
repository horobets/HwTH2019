package task14.imdbtopmovies.imdbmovieinfo;

import java.util.HashMap;
import java.util.Map;

public enum Genre {
    DRAMA("Drama"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    SHORT("Short"),
    CRIME("Crime"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    FAMILY("Family"),
    ACTION("Action"),
    FANTASY("Fantasy"),
    ADVENTURE("Adventure"),
    SCIFI("Sci-Fi"),
    ANIMATION("Animation"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    WAR("War"),
    BIOGRAPHY("Biography"),
    DOCUMENTARY("Documentary"),
    MUSICAL("Musical"),
    SPORT("Sport"),
    REALITYTV("Reality-TV"),
    TALKSHOW("Talk-Show"),
    WESTERN("Western"),
    NEWS("News"),
    GAMESHOW("Game-Show"),
    FILMNOIR("Film-Noir"),
    ADULT("Adult");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    // Reverse Lookup (ref: https://howtodoinjava.com/java/enum/java-enum-string-example/ )
    private static final Map<String, Genre> lookup = new HashMap<>();

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