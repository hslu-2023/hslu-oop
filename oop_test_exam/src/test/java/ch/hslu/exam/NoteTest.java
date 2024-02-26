package ch.hslu.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void testGetGradeValue(){
        assertEquals(6.009f, Note.A.getGradValue(), 0.01);
        assertEquals(2.99f, Note.F.getGradValue(), 0.01);
    }

}