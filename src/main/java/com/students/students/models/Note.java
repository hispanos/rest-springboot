package com.students.students.models;

public class Note {
    //Crea una clase Nota con los atributos id, student, subject y note.
    private int id;
    private Student student;
    private Subject subject;
    private int note;

    public Note (int id, Student student, Subject subject, int note) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getNote() {
        return note;
    }
}
