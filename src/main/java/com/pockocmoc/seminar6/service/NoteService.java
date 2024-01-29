package com.pockocmoc.seminar6.service;

import com.pockocmoc.seminar6.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    Note createNote(Note note);

    List<Note> findAll();

    Optional<Note> findById(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);


}
