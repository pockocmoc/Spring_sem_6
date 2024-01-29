package com.pockocmoc.seminar6.controller;

import com.pockocmoc.seminar6.model.Note;
import com.pockocmoc.seminar6.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getNotesById(@PathVariable("id") Long id) {
        Optional<Note> noteId;
        try {
            noteId = noteService.findById(id);
            if (noteId.isPresent()) {
                return ResponseEntity.ok(noteId);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.empty());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long id, @RequestBody Note noteDetails) {
        Note updatedNote = noteService.updateNote(id, noteDetails);
        return ResponseEntity.ok(updatedNote);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }


}


