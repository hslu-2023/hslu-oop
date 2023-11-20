package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void testEqualsWithEqualsVerifier() {
        EqualsVerifier.simple().forClass(Temperature.class).verify();
    }

    @Test
    void testEqualsWithEqual() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(3);

        assertEquals(true, temperature1.equals(temperature2));
        // alternative: assertTrue(person1.equals(person2));
    }

    @Test
    void testEqualsWithNotEqual() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(2);

        assertEquals(false, temperature1.equals(temperature2));
        // alternative: assertFalse(person1.equals(person2));

    }

    @Test
    void testHashCodeEqual() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(3);

        assertEquals(temperature1.hashCode(), temperature2.hashCode());
    }

    @Test
    void testHashCodeNotEqual() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(2);

        assertNotEquals(temperature1.hashCode(), temperature2.hashCode());
    }

    @Test
    void testCompareToThisObjectHigher() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(2);

        assertEquals(1, temperature1.compareTo(temperature2));
    }

    @Test
    void testCompareToOtherObjectHigher() {
        Temperature temperature1 = new Temperature(2);
        Temperature temperature2 = new Temperature(3);

        assertEquals(-1, temperature1.compareTo(temperature2));
    }

    @Test
    void testCompareToEqualObjects() {
        Temperature temperature1 = new Temperature(2);
        Temperature temperature2 = new Temperature(2);

        assertEquals(0, temperature1.compareTo(temperature2));
    }
}