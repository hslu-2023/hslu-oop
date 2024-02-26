package ch.hslu.oop.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuittungTest {

    @Test
    void testToString() {
        Quittung quittung = new Quittung();
        String expected = "Quittung[timestamp=" + quittung.getTimestamp() + "]";
        String actual = quittung.toString();

        assertEquals(expected, actual);
    }

}