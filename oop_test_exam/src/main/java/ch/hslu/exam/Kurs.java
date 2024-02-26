package ch.hslu.exam;

public class Kurs {

    private String courseName;

    private Note note;

    public Kurs(String courseName, Note note) {
        this.courseName = courseName;
        this.note = note;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Note getNote() {
        return this.note;
    }
}
