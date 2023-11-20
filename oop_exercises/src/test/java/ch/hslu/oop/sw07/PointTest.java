package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testEqualsWithEqualsVerifier() {
        EqualsVerifier.simple().forClass(Point.class).verify();
    }
    @Test
    public void testEqualsWithEqual() {
        Point point1 = new Point(2,3);
        Point point2 = new Point(2,3);

        assertEquals(true, point1.equals(point2));
    }

    @Test
    public void testEqualsWithNotEqual() {
        Point point1 = new Point(2,3);
        Point point2 = new Point(3, 2);

        assertEquals(false, point1.equals(point2));
    }

    @Test
    public void testHashCodeEqual() {
        Point point1 = new Point(2,3);
        Point point2 = new Point(2,3);

        assertEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() {
        Point point1 = new Point(2,3);
        Point point2 = new Point(3, 2);

        assertNotEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    void testCompareToThisObjectHigher() {
        Point point1 = new Point(13,12);
        Point point2 = new Point(2, 3);

        assertEquals(1, point1.compareTo(point2));
    }

    @Test
    void testCompareToOtherObjectHigher() {
        Point point1 = new Point(1,1);
        Point point2 = new Point(30,18);

        assertEquals(-1, point1.compareTo(point2));
    }

    @Test
    void testCompareToEqualObjects() {
        Point point1 = new Point(2, 2);
        Point point2 = new Point(2,2);

        assertEquals(0, point1.compareTo(point2));
    }
}