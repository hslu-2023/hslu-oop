package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testConstructor() {
        long id = 2;
        String lastName = "Lima";
        String firstName = "Raquel";

        Person person = new Person(id, lastName, firstName);

        assertEquals(id, person.getId());
        assertEquals(lastName, person.getLastName());
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void testEqualsWithEqualsVerifier() {
        EqualsVerifier.simple().forClass(Person.class).withIgnoredFields("lastName", "firstName").verify();
    }

    @Test
    public void testEqualsWithEqual() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(2, "Doe", "John");

        assertEquals(true, person1.equals(person2));
        // alternative: assertTrue(person1.equals(person2));

    }

    @Test
    public void testEqualsWithNotEqual() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(1, "Lima", "Raquel");

        assertEquals(false, person1.equals(person2));
        // alternative: assertFalse(person1.equals(person2));

    }

    @Test
    public void testHashCodeEqual() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(2, "Doe", "John");

        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(1, "Lima", "Raquel");

        assertNotEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testCompareToThisObjectHigher() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(1, "Lima", "Raquel");

        assertEquals(1, person1.compareTo(person2));
    }

    @Test
    void testCompareToOtherObjectHigher() {
        Person person1 = new Person(1, "Lima", "Raquel");
        Person person2 = new Person(4, "Lima", "Raquel");

        assertEquals(-1, person1.compareTo(person2));

    }

    @Test
    void testCompareToEqualObjects() {
        Person person1 = new Person(2, "Lima", "Raquel");
        Person person2 = new Person(2, "Doe", "John");

        assertEquals(0, person1.compareTo(person2));
    }

}