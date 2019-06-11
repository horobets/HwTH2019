package lesson17;

import java.util.HashMap;
import java.util.Map;

public class Lesson17 {
    public String wordAppend(String[] strings) {

        String result = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
                if (map.get(s) % 2 == 0)
                    result += s;
            }
        }

        return result;
    }


}
