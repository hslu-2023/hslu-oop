package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.car.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    Engine engine;

    @BeforeEach
    public void initNewObject() {
        engine = new Engine();
    }

    @Test
    void testSwitchOn() {
        engine.switchOn();
        assertTrue(engine.isSwitchedOn());
        assertEquals(5600, engine.getRpm());
    }

    @Test
    void testSwitchOff() {
        engine.switchOn();
        engine.switchOff();
        assertFalse(engine.isSwitchedOn());
        assertEquals(0, engine.getRpm());
    }

    @Test
    void testIsSwitchedOn() {
        assertFalse(engine.isSwitchedOn());
        engine.switchOn();
        assertTrue(engine.isSwitchedOn());
    }

    @Test
    void testIsSwitchedOff() {
        assertTrue(engine.isSwitchedOff());
        engine.switchOn();
        assertFalse(engine.isSwitchedOff());
    }

    @Test
    void addPropertyChangeListener() {
    }

    @Test
    void removePropertyChangeListener() {
    }

    @Test
    void firePropertyChangeEvent() {
    }


}