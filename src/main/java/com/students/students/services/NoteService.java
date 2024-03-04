package com.students.students.services;

import com.students.students.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteService {

    private List<Note> notes;
    public NoteService() {
        this.notes = new ArrayList<>();
    }

    public List<Note> getNotesByStudentId(int studentId) {
        return notes.stream()
                .filter(note -> note.getStudent().getId() == studentId)
                .toList();
    }

    public Note getNoteById(int id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Note addNote (Note note) {
        notes.add(note);
        return note;
    }
}
