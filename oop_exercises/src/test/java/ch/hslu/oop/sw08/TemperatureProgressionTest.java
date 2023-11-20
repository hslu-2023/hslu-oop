package ch.hslu.oop.sw08;

import ch.hslu.oop.sw08.temperature.Temperature;
import ch.hslu.oop.sw08.temperature.TemperatureProgressionInterface;
import ch.hslu.oop.sw08.temperature.TemperatureProgression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureProgressionTest {

    TemperatureProgressionInterface list;

    @BeforeEach
    void setUp() {
        list = new TemperatureProgression();
    }

    @Test
    void testAddTemperatureObjects() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));

        assertEquals(2, list.getCount());
    }

    @Test
    void testClear() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));

        list.clear();

        assertEquals(0, list.getCount());
    }

    @Test
    void testGetCount() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));
        list.add(new Temperature(13));

        assertEquals(3, list.getCount());
    }

    @Test
    void testGetMax() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));
        list.add(new Temperature(14));

        assertEquals(14, list.getMax());
    }

    @Test
    void testGetMaxEmpty() {
        assertEquals(0, list.getMax());
    }

    @Test
    void testGetMin() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));
        list.add(new Temperature(14));

        assertEquals(12, list.getMin());
    }

    @Test
    void testGetMinEmpty() {
        assertEquals(0, list.getMin());
    }

    @Test
    void testGetAverage() {
        list.add(new Temperature(12));
        list.add(new Temperature(13));
        list.add(new Temperature(14));

        assertEquals(13, list.getAverage());
    }

    @Test
    void testGetAverageSingleElement() {
        list.add(new Temperature(12));

        assertEquals(12, list.getAverage());
    }

    @Test
    void testGetAverageEmpty() {
        assertEquals(0, list.getAverage());
    }

}