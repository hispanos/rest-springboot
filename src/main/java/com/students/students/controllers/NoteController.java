package com.students.students.controllers;

import com.students.students.models.Note;
import com.students.students.services.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notas encontradas."),
        @ApiResponse(responseCode = "404", description = "No se encontraron notas.", content = @Content),
    })
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
        if (note == null || note.getSubject() == null) {
            throw new NullPointerException("La propiedad subject es requerida.");
        }
        if (note.getNote() < 0) {
            throw new IllegalArgumentException("La propiedad nota no puede ser negativa.");
        }
        return noteService.addNote (note);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("Se ha producido un error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
