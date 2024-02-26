package ch.hslu.exam;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testConstructor() {
        Student student = new Student(800000, "Raquel", "Lima");

        assertEquals(800000, student.getId());
        assertEquals("Raquel", student.getFirstName());
        assertEquals("Lima", student.getLastName());
    }

    @Test
    void testToString() {
        Student student = new Student(800000, "Raquel", "Lima");

        String expected = "Student[id=800000; firstName='Raquel'; lastName='Lima']";

        assertEquals(expected, student.toString());
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Student.class).withIgnoredFields("firstName", "lastName", "visitedCourses", "changeListeners").verify();
    }

    @Test
    public void testHashCodeEqual() {
        Student student1 = new Student(800000, "Raquel", "Lima");
        Student student2 = new Student(800000, "John", "Doe");

        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    public void testConstructorInvalidIdException() {
        assertThatThrownBy(() -> {
            new Student(1234, "Raquel", "Lima");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IllegalArgumentException caught! Please enter a valid id value above 500000");
    }

    @Test
    public void testConstructorValidId() {
        Student student = new Student(800000, "Raquel", "Lima");
        assertEquals(800000, student.getId());
    }

    @Test
    public void testConstructorLastNameNull() {
        assertThatThrownBy(() -> {
            new Student(800000, "Raquel", null);
        })
                .isInstanceOf(NullPointerException.class)
                .hasMessage("NullPointerException caught! Please enter a valid firstname.");
    }

    @Test
    public void testConstructorLastNameInvalid() {
        assertThatThrownBy(() -> {
            new Student(800000, "Raquel", "L");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IllegalArgumentException caught! Please enter a valid firstname with a minimum of 2 characters.");
    }

    @Test
    public void testConstructorLastNameValid() {
        Student student = new Student(800000, "Raquel", "Li");
        assertEquals("Li", student.getLastName());
    }

    @Test
    public void testGetAverageException() {

        assertThatThrownBy(() -> {
            new Student(800000, "Raquel", "Lima").getVisitedCoursesAverage();
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("IllegalStateException caught! You have not visited any courses");
    }

    @Test
    public void testGetAverageWith3Courses() {
        Student student = new Student(800000, "Raquel", "Lima");

        Kurs kurs1 = new Kurs("oop", Note.A);
        Kurs kurs2 = new Kurs("anlis", Note.B);
        Kurs kurs3 = new Kurs("lial", Note.C);

        student.visitCourse(kurs1);
        student.visitCourse(kurs2);
        student.visitCourse(kurs3);

        float average = student.getVisitedCoursesAverage();

        assertEquals(5.5, average, 0.01);
    }

}