package com.pockocmoc.seminar6.repository;

import com.pockocmoc.seminar6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с заметками в базе данных.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
