package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void initNewObject() {
        car = new Car();
    }

    @Test
    void componentsInitialization() {
        assertNotNull(car.getEngine());
        assertNotNull(car.getFrontLight());
        assertNotNull(car.getBackLight());
        assertNotNull(car.getWiper());
    }

    @Test
    void handleEngineEvent() {
    }

    @Test
    void propertyChange() {
    }

    @Test
    void testSwitchOn() {
        car.switchOn();

        assertTrue(car.isSwitchedOn());
        assertTrue(car.getEngine().isSwitchedOn());
        assertTrue(car.getFrontLight().isSwitchedOn());
        assertTrue(car.getBackLight().isSwitchedOn());
        assertFalse(car.getWiper().isSwitchedOn());
    }

    @Test
    void testSwitchOff() {
        car.switchOn();
        car.switchOff();

        assertFalse(car.isSwitchedOn());
        assertFalse(car.getEngine().isSwitchedOn());
        assertFalse(car.getFrontLight().isSwitchedOn());
        assertFalse(car.getBackLight().isSwitchedOn());
        assertFalse(car.getWiper().isSwitchedOn());
    }

    @Test
    void testIsSwitchedOn() {
        assertFalse(car.isSwitchedOn());

        car.switchOn();

        assertTrue(car.isSwitchedOn());
        assertTrue(car.getEngine().isSwitchedOn());
        assertTrue(car.getFrontLight().isSwitchedOn());
        assertTrue(car.getBackLight().isSwitchedOn());
        assertFalse(car.getWiper().isSwitchedOn());
    }

    @Test
    void testIsSwitchedOff() {
        assertTrue(car.isSwitchedOff());

        car.switchOn();

        assertFalse(car.isSwitchedOff());
        assertFalse(car.getEngine().isSwitchedOff());
        assertFalse(car.getFrontLight().isSwitchedOff());
        assertFalse(car.getBackLight().isSwitchedOff());
        assertTrue(car.getWiper().isSwitchedOff());
    }

}