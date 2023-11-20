package ch.hslu.oop.sw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonNameComparatorTest {

    @Test
    void compare_DifferentLastName_ShouldReturnPositive() {
        Person person1 = new Person(1, "Doe", "John");
        Person person2 = new Person(2, "Lima", "Raquel");
        PersonNameComparator comparator = new PersonNameComparator();

        int result = comparator.compare(person1, person2);

        System.out.println(result);

        assertTrue(result > 0);
    }
}