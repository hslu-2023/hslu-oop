package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.car.Wiper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WiperTest {

    Wiper wiper;

    @BeforeEach
    public void initNewObject() {
        wiper = new Wiper();
    }

    @Test
    void testSwitchOn() {
        wiper.switchOn();
        assertTrue(wiper.isSwitchedOn());
        assertEquals(60, wiper.getRpm());
    }

    @Test
    void testSwitchOff() {
        wiper.switchOn();
        wiper.switchOff();
        assertFalse(wiper.isSwitchedOn());
        assertEquals(0, wiper.getRpm());
    }

    @Test
    void testIsSwitchedOn() {
        assertFalse(wiper.isSwitchedOn());
        wiper.switchOn();
        assertTrue(wiper.isSwitchedOn());
    }

    @Test
    void testIsSwitchedOff() {
        assertTrue(wiper.isSwitchedOff());
        wiper.switchOn();
        assertFalse(wiper.isSwitchedOff());
    }
}