package task8.kismia.pages.profile;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }


    // Reverse Lookup (ref: https://howtodoinjava.com/java/enum/java-enum-string-example/ )
    private static final Map<String, Gender> lookup = new HashMap<String, Gender>();

    //Populate the lookup table on loading time
    static {
        for (Gender gender : Gender.values()) {
            lookup.put(gender.toString(), gender);
        }
    }

    //This method can be used for reverse lookup purpose
    public static Gender get(String description) {
        return lookup.get(description);
    }

}
