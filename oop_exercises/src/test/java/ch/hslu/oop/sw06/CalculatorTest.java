package ch.hslu.oop.sw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new CalculatorImpl();

    @Test
    void addPositiveNumbers() {
        int result = calculator.addition(2, 10);
        assertEquals(12, result);
    }

    @Test
    void addNegativeNumbers() {
        int result = calculator.addition(-2, -10);
        assertEquals(-12, result);
    }

    @Test
    void addPositiveAndNegativeNumbers() {
        int result = calculator.addition(-2, 10);
        assertEquals(8, result);
    }

    @Test
    void addZero() {
        int result = calculator.addition(0, 0);
        assertEquals(0, result);
    }
}