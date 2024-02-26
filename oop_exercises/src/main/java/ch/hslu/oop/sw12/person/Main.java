package ch.hslu.oop.sw12.person;

import java.util.*;

/**
 * The {@code Main} class serves as the entry point for the application.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Main {

    private static final Comparator<Person> lastNameComp =
            (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
    private static final Comparator<Person> firstNameComp =
            (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());


    /**
     * The main method is the entry point of the program.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {

        Person p1 = new Person(1, "Lima", "Raquel");
        Person p2 = new Person(2, "Geser", "Paul");
        Person p3 = new Person(2, "Mattern", "Elias");

        List<Person> persList = new ArrayList<>();

        persList.add(p1);
        persList.add(p2);
        persList.add(p3);

        persList.sort(lastNameComp);
        System.out.println(persList);
        persList.sort(lastNameComp.reversed());
        System.out.println(persList);
        persList.sort(lastNameComp
                .thenComparing(firstNameComp));
        System.out.println(persList);

    }
}
