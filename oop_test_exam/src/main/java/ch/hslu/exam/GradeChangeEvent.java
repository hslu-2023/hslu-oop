package ch.hslu.exam;

import java.util.EventObject;



public class GradeChangeEvent extends EventObject {

    private final  Kurs kurs;

    public GradeChangeEvent(Object source, Kurs kurs) {
        super(source);
        this.kurs = kurs;
    }

    public Kurs getKurs() {
        return kurs;
    }
}
