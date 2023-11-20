package ch.hslu.oop.sw06.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    Demo demo = new Demo();

    @Test
    void testFirstParameter() {
        int result = demo.max(3, 2, 1);
        assertEquals(3, result);
    }

    @Test
    void testSecondParameter() {
        int result = demo.max(2, 3, 1);
        assertEquals(3, result);
    }

    @Test
    void testSecondThirdParameter() {
        int result = demo.max(1, 2, 3);
        assertEquals(3, result);
    }

}