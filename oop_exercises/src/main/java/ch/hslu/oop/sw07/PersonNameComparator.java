package ch.hslu.oop.sw07;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Person p1, Person p2) {
        int compare = p1.getLastName().compareTo(p2.getLastName());
        if (compare == 0) {
            compare = p1.getFirstName().compareTo(p2.getFirstName());
        }
        return compare;
    }
}
