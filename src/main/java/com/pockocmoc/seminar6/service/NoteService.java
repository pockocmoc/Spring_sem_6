package com.pockocmoc.seminar6.service;

import com.pockocmoc.seminar6.model.Note;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с заметками.
 */
public interface NoteService {

    /**
     * Создает новую заметку.
     *
     * @param note заметка для создания
     * @return созданная заметка
     */
    Note createNote(Note note);

    /**
     * Возвращает список всех заметок.
     *
     * @return список всех заметок
     */
    List<Note> findAll();

    /**
     * Возвращает заметку по ее идентификатору.
     *
     * @param id идентификатор заметки
     * @return заметка с указанным идентификатором или пустое значение, если заметка не найдена
     */
    Optional<Note> findById(Long id);

    /**
     * Обновляет заметку с указанным идентификатором.
     *
     * @param id   идентификатор заметки для обновления
     * @param note новая версия заметки
     * @return обновленная заметка
     */
    Note updateNote(Long id, Note note);

    /**
     * Удаляет заметку с указанным идентификатором.
     *
     * @param id идентификатор заметки для удаления
     */
    void deleteNote(Long id);

}