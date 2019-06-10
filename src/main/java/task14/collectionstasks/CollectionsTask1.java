package task14.collectionstasks;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionsTask1 {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        //Ваш код

        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Charlie"));
        cats.add(new Cat("Loki"));
        cats.add(new Cat("Zoe"));
        cats.add(new Cat("Chloe"));

        return cats;
    }

    public static Set<Dog> createDogs() {
        //Ваш код

        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Cooper"));
        dogs.add(new Dog("Bailey"));
        dogs.add(new Dog("Buster"));

        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //Ваш код
        Set<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);

        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //Ваш код

        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Object setElement = iterator.next();
            if (setElement instanceof Cat) {
                iterator.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //Ваш код
        System.out.printf("%nPets: %n");
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Object setElement = iterator.next();
            if (setElement instanceof Pet) {
                System.out.println(setElement);
            }
        }

    }

    public static class Cat extends Pet {
        public Cat(String name) {
            super(name);
        }
    }

    public static class Dog extends Pet {
        public Dog(String name) {
            super(name);
        }
    }

    public static abstract class Pet {
        private String name;

        public Pet(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}