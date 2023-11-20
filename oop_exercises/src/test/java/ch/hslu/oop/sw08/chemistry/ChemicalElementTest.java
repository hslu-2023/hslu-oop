package ch.hslu.oop.sw08.chemistry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {

    @Test
    void getPhysicalState() {
        Lead lead = new Lead(20);
        System.out.println(lead.getPhysicalState());
    }
}