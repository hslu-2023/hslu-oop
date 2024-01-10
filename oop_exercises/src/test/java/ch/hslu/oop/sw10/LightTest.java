package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.car.Light;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    Light light;

    @BeforeEach
    public void initNewObject() {
        light = new Light();
    }

    @Test
    void testSwitchOn() {
        light.switchOn();
        assertTrue(light.isSwitchedOn());
        assertEquals(1500, light.getLumen());
    }

    @Test
    void testSwitchOff() {
        light.switchOn();
        light.switchOff();
        assertFalse(light.isSwitchedOn());
        assertEquals(0, light.getLumen());
    }

    @Test
    void testIsSwitchedOn() {
        assertFalse(light.isSwitchedOn());
        light.switchOn();
        assertTrue(light.isSwitchedOn());
    }

    @Test
    void testIsSwitchedOff() {
        assertTrue(light.isSwitchedOff());
        light.switchOn();
        assertFalse(light.isSwitchedOff());
    }
}