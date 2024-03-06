package com.students.students.controllers;

import com.students.students.models.Note;
import com.students.students.services.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController() {
        this.noteService = new NoteService();
    }

    @Operation(summary = "Obtener todas las notas de un estudiante por su id.")
    @GetMapping("/student/{studentId}")
    public List<Note> getNotesByStudentId(@PathVariable int studentId) {
        return noteService.getNotesByStudentId(studentId);
    }

    @Operation(summary = "Obtener todas las notas por su id.")
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @Operation(summary = "Añadir una nota.")
    @PostMapping("/add")
    public Note addNote (@RequestBody Note note) {
        return noteService.addNote (note);
    }
}
