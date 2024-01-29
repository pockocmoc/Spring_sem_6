package com.pockocmoc.seminar6.service;

import com.pockocmoc.seminar6.model.Note;
import com.pockocmoc.seminar6.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для работы с заметками.
 */
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    /**
     * Создает новую заметку.
     *
     * @param note заметка для создания
     * @return созданная заметка
     */
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Возвращает список всех заметок.
     *
     * @return список всех заметок
     */
    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    /**
     * Возвращает заметку по ее идентификатору.
     *
     * @param id идентификатор заметки
     * @return заметка с указанным идентификатором или пустое значение, если заметка не найдена
     */
    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    /**
     * Обновляет заметку с указанным идентификатором.
     *
     * @param id          идентификатор заметки для обновления
     * @param noteDetails новая версия заметки
     * @return обновленная заметка
     */
    @Override
    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> optionalNote = findById(id);
        Note note = optionalNote.get();
        note.setTitle(noteDetails.getTitle());
        note.setContents(noteDetails.getContents());
        return noteRepository.save(note);
    }

    /**
     * Удаляет заметку с указанным идентификатором.
     *
     * @param id идентификатор заметки для удаления
     */
    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
