package ch.hslu.oop.sw09;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Unit tests for the Temperature class, covering equality, hash code, comparison, conversion, and exception handling.
 *
 * @author Raquel Lima
 * @version 2.0
 */
class TemperatureTest {

    //test equals()

    @Test
    void testEqualsWithEqualsVerifier() {
        EqualsVerifier.simple().forClass(ch.hslu.oop.sw08.temperature.Temperature.class).verify();
    }

    @Test
    void testEqualityWithEqualObjects() {
        Temperature temperature1 = Temperature.createFromCelsius(3.0f);
        Temperature temperature2 = Temperature.createFromCelsius(3.0f);

        assertTrue(temperature1.equals(temperature2));
    }

    @Test
    void testEqualityWithNotEqualObjects() {
        Temperature temperature1 = Temperature.createFromCelsius(3.0f);
        Temperature temperature2 = Temperature.createFromCelsius(2.0f);

        assertFalse(temperature1.equals(temperature2));
    }

    //test hashCode()

    @Test
    void testHashCodeEqual() {
        Temperature temperature1 = Temperature.createFromCelsius(3.0f);
        Temperature temperature2 = Temperature.createFromCelsius(3.0f);

        assertEquals(temperature1.hashCode(), temperature2.hashCode());
    }

    @Test
    void testHashCodeNotEqual() {
        Temperature temperature1 = Temperature.createFromCelsius(3.0f);
        Temperature temperature2 = Temperature.createFromCelsius(2.0f);

        assertNotEquals(temperature1.hashCode(), temperature2.hashCode());
    }

    //test compareTo()

    @Test
    void testCompareToThisObjectHigher() {
        Temperature temperature1 = Temperature.createFromCelsius(3.0f);
        Temperature temperature2 = Temperature.createFromCelsius(2.0f);

        assertEquals(1.0f, temperature1.compareTo(temperature2));
    }

    @Test
    void testCompareToOtherObjectHigher() {
        Temperature temperature1 = Temperature.createFromCelsius(2.0f);
        Temperature temperature2 = Temperature.createFromCelsius(3.0f);

        assertEquals(-1.0f, temperature1.compareTo(temperature2));
    }

    @Test
    void testCompareToEqualObjects() {
        Temperature temperature1 = Temperature.createFromCelsius(2.0f);
        Temperature temperature2 = Temperature.createFromCelsius(2.0f);

        assertEquals(0.0f, temperature1.compareTo(temperature2));
    }

    //test convertKelvinToCelsius()

    @Test
    void testConvertKelvinToCelsius() {
        assertEquals(-263.15f, Temperature.convertKelvinToCelsius(10.0f));
        assertEquals(-283.15f, Temperature.convertKelvinToCelsius(-10.0f));
        assertEquals(-273.15f, Temperature.convertKelvinToCelsius(0.0f));

    }

    //test convertCelsiusToKelvin()

    @Test
    void testConvertCelsiusToKelvin() {
        assertEquals(283.15f, Temperature.convertCelsiusToKelvin(10.0f));
        assertEquals(263.15f, Temperature.convertCelsiusToKelvin(-10.0f));
        assertEquals(273.15f, Temperature.convertCelsiusToKelvin(0.0f));
    }

    //test createFromCelsius()

    @Test
    void testCreateFromCelsius() {
        Temperature temperature = Temperature.createFromCelsius(12.0f);
        assertEquals(12.0f, temperature.getCelsius());
    }

    //test createFromKelvin()

    @Test
    void testCreateFromKelvin() {
        Temperature temperature = Temperature.createFromKelvin(120.0f);
        assertEquals(120.0f, temperature.getKelvin());
    }

    //test checkTemperature

    @Test
    void testExceptionCheckTemperature() {
        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> {
                    Temperature.createFromCelsius(-300.0f);
                });
        assertEquals("Invalid temperature value: -300.0 Celsius. Temperature should be greater than or equal to -273.15 Celsius.", e.getMessage());
    }

    //test checkTemperature with AssertJ

    @Test
    void testExceptionCheckTemperatureWithAssertJ() {
        assertThatThrownBy(() -> {
            Temperature.createFromCelsius(-300.0f);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid temperature value: -300.0 Celsius. Temperature should be greater than or equal to -273.15 Celsius.");
    }

}