package com.pockocmoc.seminar6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Модель заметки.
 */
@Data
@Entity
@Table(name = "notes")
public class Note {

    /**
     * Уникальный идентификатор заметки.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Заголовок заметки.
     */
    @Column(nullable = false)
    private String title;
    /**
     * Содержимое заметки.
     */
    @Column(nullable = false)
    private String contents;
    /**
     * Время создания заметки.
     */
    @Column(name = "creation_time", nullable = true)
    private LocalDateTime creationTime;

    /**
     * Устанавливает время создания заметки при сохранении в базу данных.
     */
    @PrePersist
    public void setCreationTime() {
        this.creationTime = LocalDateTime.now();
    }


}
