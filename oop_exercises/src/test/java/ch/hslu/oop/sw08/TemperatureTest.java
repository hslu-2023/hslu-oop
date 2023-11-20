package ch.hslu.oop.sw08;

import ch.hslu.oop.sw08.temperature.Temperature;
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

        assertTrue(temperature1.equals(temperature2));
    }

    @Test
    void testEqualsWithNotEqual() {
        Temperature temperature1 = new Temperature(3);
        Temperature temperature2 = new Temperature(2);

        assertFalse(temperature1.equals(temperature2));
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

    @Test
    void testConvertKelvinToCelsius(){
        assertEquals(-263.15f,Temperature.convertKelvinToCelsius(10));
        assertEquals(-283.15f,Temperature.convertKelvinToCelsius(-10));
        assertEquals(-273.15f,Temperature.convertKelvinToCelsius(0));
        assertEquals(0,Temperature.convertKelvinToCelsius(273.15f));
    }

    @Test
    void testConvertCelsiusToKelvin(){
        assertEquals(283.15f,Temperature.convertCelsiusToKelvin(10));
        assertEquals(263.15f,Temperature.convertCelsiusToKelvin(-10));
        assertEquals(273.15f,Temperature.convertCelsiusToKelvin(0));
        assertEquals(0,Temperature.convertCelsiusToKelvin(-273.15f));
    }
}