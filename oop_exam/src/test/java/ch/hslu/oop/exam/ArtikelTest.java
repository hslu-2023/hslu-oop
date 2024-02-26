package ch.hslu.oop.exam;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ArtikelTest {

    @Test
    void testConstructorWithValidValuesWithoutMwst() {
        Artikel artikel = new Artikel("pencil", 1.1f);

        assertEquals("pencil", artikel.getBezeichnung());
        assertEquals(1.1f, artikel.getPreis(), 0.01);
        assertEquals(MWST.Normal, artikel.getMwst());
    }

    @Test
    void testConstructorWithValidValuesAndMwst() {
        Artikel artikel = new Artikel("pencil", 1.1f, MWST.Reduziert);

        assertEquals("pencil", artikel.getBezeichnung());
        assertEquals(1.1f, artikel.getPreis(), 0.01);
        assertEquals(MWST.Reduziert, artikel.getMwst());
    }

    @Test
    void testConstructorWithNullBezeichnung() {
        assertThatThrownBy(() -> {
            new Artikel(null, 1.1f);
        })
                .isInstanceOf(NullPointerException.class)
                .hasMessage("NullPointerException caught! Please enter a valid description value.");
    }

    @Test
    void testConstructorWithInvalidBezeichnung() {
        assertThatThrownBy(() -> {
            new Artikel("p", 1.1f);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IllegalArgumentException caught! Please enter a bezeichnung value with more than 2 characters.");
    }

    @Test
    void testConstructorWithInvalidPrice() {
        assertThatThrownBy(() -> {
            new Artikel("pencil", 0.0f);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IllegalArgumentException caught! Please enter a positive price value higher than 0.0f");
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Artikel.class).withIgnoredFields("preis", "mwst").verify();
    }

    @Test
    public void calculateArtikelNettoPreis() {
        Artikel artikel = new Artikel("pencil", 1.1f, MWST.Reduziert);
        assertEquals(1.1f, artikel.calculateArtikelNettoPreis(), 0.01);
    }

    @Test
    public void calculateArtikelBruttoPreis() {
        Artikel artikel = new Artikel("pencil", 1.1f, MWST.Beherbergung);
        float expected = 1.1f * 3.8f;
        assertEquals(expected, artikel.calculateArtikelBruttoPreis(), 0.01);
    }

}