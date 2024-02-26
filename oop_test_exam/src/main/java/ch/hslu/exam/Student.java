package ch.hslu.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    final private long id;
    final private String firstName;
    final private String lastName;

    final private static long ID_MIN = 500000;

    final private List<Kurs> visitedCourses = new ArrayList<>();

    private final List<GradeChangeListener> changeListeners = new ArrayList<>();

    public Student(final long id, final String firstName, final String lastName) {
        if (id < ID_MIN) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a valid id value above " + ID_MIN);
        }
        if (lastName == null) {
            throw new NullPointerException("NullPointerException caught! Please enter a valid firstname.");
        } else if (lastName.length() < 2) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a valid firstname with a minimum of 2 characters.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void addPropertyChangeListener(final GradeChangeListener listener) {
        this.changeListeners.add(listener);
    }

    public void removePropertyChangeListener(
            final GradeChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    /**
     * Informiert alle PropertyChangeListeners über PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(final GradeChangeEvent pcEvent) {
        for (final GradeChangeListener listener : this.changeListeners) {
            listener.gradeChange(pcEvent);
        }
    }


    public void visitCourse(final Kurs course) {
        if (Float.compare(course.getNote().getGradValue(), 6.0f) == 0) {
            final GradeChangeEvent gcEvent = new GradeChangeEvent(this, course);
            this.firePropertyChangeEvent(gcEvent);
        }
        this.visitedCourses.add(course);
    }

    public int getTotalVisitedCoursesNumber() {
        return this.visitedCourses.size();
    }

    public float getVisitedCoursesAverage() {
        return (float) this.visitedCourses.stream().mapToDouble(t -> t.getNote().getGradValue()).average().orElseThrow(() -> new IllegalStateException("IllegalStateException caught! You have not visited any courses"));
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public final String toString() {
        return "Student[" +
                "id=" + this.id +
                "; firstName='" + this.firstName + '\'' +
                "; lastName='" + this.lastName + '\'' +
                ']';
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Student p)
                && (p.getId() == this.getId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.id);
    }
}
