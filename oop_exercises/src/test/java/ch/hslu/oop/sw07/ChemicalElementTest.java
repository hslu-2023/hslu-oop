package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {

    @Test
    void testEqualsWithEqualsVerifier() {
        EqualsVerifier.simple().forClass(ChemicalElement.class).withIgnoredFields("temperatureCelsius", "boilingPoint", "meltingPoint").verify();
    }

    @Test
    void testEqualsWithEqual() {
        Nitrogen element1 = new Nitrogen(2);
        Nitrogen element2 = new Nitrogen(3);

        assertTrue(element1.equals(element2));
    }

    @Test
    void testEqualsWithNotEqual(){
        Nitrogen element1 = new Nitrogen(2);
        Lead element2 = new Lead(2);

        assertFalse(element1.equals(element2));
    }

    @Test
    public void testHashCodeEqual() {
        Nitrogen element1 = new Nitrogen(2);
        Nitrogen element2 = new Nitrogen(3);

        assertEquals(element1.hashCode(), element2.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() {
        Nitrogen element1 = new Nitrogen(2);
        Lead element2 = new Lead(2);

        assertNotEquals(element1.hashCode(), element2.hashCode());
    }

    @Test
    void testCompareToThisObjectHigher() {
        Nitrogen nitrogen1 = new Nitrogen(3);
        Nitrogen nitrogen2 = new Nitrogen(2);

        assertEquals(1, nitrogen1.compareTo(nitrogen2));
    }

    @Test
    void testCompareToOtherObjectHigher() {
        Nitrogen nitrogen1 = new Nitrogen(2);
        Nitrogen nitrogen2 = new Nitrogen(3);

        assertEquals(-1, nitrogen1.compareTo(nitrogen2));
    }

    @Test
    void testCompareToEqualObjects() {
        Nitrogen nitrogen1 = new Nitrogen(2);
        Nitrogen nitrogen2 = new Nitrogen(2);

        assertEquals(0, nitrogen1.compareTo(nitrogen2));
    }

}