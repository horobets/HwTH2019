package task14.collectionstasks;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

import java.util.*;

public class CollectionsTask4 {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //Ваш код

        Map<String, Cat> catMap = new HashMap<>();
        catMap.put("Charlie", new Cat("Charlie"));
        catMap.put("Milo", new Cat("Milo"));
        catMap.put("George", new Cat("George"));
        catMap.put("Loki", new Cat("Loki"));
        catMap.put("Luna", new Cat("Luna"));
        catMap.put("Chloe", new Cat("Chloe"));
        catMap.put("Lucy", new Cat("Lucy"));
        catMap.put("Lily", new Cat("Lily"));
        catMap.put("Sophie", new Cat("Sophie"));
        catMap.put("Cleo", new Cat("Cleo"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //Ваш код
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        //Ваш код


        System.out.printf("%nCats: %n");
        Iterator<Cat> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object setElement = iterator.next();
            System.out.println(setElement);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}