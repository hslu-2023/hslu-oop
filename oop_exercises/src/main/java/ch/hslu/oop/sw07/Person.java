package ch.hslu.oop.sw07;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private final long id;

    private String lastName;

    private String firstName;

    protected Person(final long id, final String lastName, final String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Person p)
                && (p.id == this.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public int compareTo(Person other) {
        if (this == other){
            return 0;
        }
        return Long.compare(this.id, other.id);
    }
}
