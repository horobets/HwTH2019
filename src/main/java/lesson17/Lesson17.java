package lesson17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lesson17 {
    public String wordAppend(String[] strings) {

        Set<String> swappedChars = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i].substring(0, 1))) {
                map.put(strings[i].substring(0, 1), i);
            } else {
                if (!swappedChars.contains(strings[i].substring(0, 1))) {
                    String temp = strings[map.get(strings[i].substring(0, 1))];
                    strings[map.get(strings[i].substring(0, 1))] = strings[i];
                    strings[i] = temp;
                    swappedChars.add(strings[i].substring(0, 1));
                }
                //map.put(strings[i].substring(0, 1), map.get(strings[i].substring(0, 1)) + 1);
            }
        }

        return "";
    }

}
