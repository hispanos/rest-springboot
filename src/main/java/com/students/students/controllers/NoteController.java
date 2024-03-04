package com.students.students.controllers;

import com.students.students.models.Note;
import com.students.students.services.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController() {
        this.noteService = new NoteService();
    }

    @GetMapping("/student/{studentId}")
    public List<Note> getNotesByStudentId(@PathVariable int studentId) {
        return noteService.getNotesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/add")
    public Note addNote (@RequestBody Note note) {
        return noteService.addNote (note);
    }
}
