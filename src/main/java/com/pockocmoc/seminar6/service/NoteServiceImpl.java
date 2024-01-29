package com.pockocmoc.seminar6.service;

import com.pockocmoc.seminar6.model.Note;
import com.pockocmoc.seminar6.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> optionalNote = findById(id);
        Note note = optionalNote.get();
        note.setTitle(noteDetails.getTitle());
        note.setContents(noteDetails.getContents());
        return noteRepository.save(note);

    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }


}
