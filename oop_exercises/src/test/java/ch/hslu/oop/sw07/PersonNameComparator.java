package ch.hslu.oop.sw07;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getLastName().compareTo(person2.getLastName());
    }
}
