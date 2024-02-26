package ch.hslu.exam;

public class Demo implements GradeChangeListener{

    Student student = new Student(800000, "Raquel", "Lima");

    private Demo() {
        this.student.addPropertyChangeListener(this);
        this.visitCourses();
    }

    public static void main(String[] args) {
       new Demo();
    }

    private void visitCourses(){
        Kurs oop = new Kurs("oop", Note.E);
        Kurs anlis = new Kurs("anlis", Note.A);

        System.out.println("Visit oop");
        this.student.visitCourse(oop);

        System.out.println("Visit anlis");
        this.student.visitCourse(anlis);
    }

    @Override
    public void gradeChange(GradeChangeEvent evt) {
        System.out.println("Congratulations! You had a 6.0 in " + evt.getKurs().getCourseName() + "!!");
    }
}
