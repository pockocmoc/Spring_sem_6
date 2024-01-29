package com.pockocmoc.seminar6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(name = "creation_time", nullable = true)
    private LocalDateTime creationTime;

    @PrePersist
    public void setCreationTime() {
        this.creationTime = LocalDateTime.now();
    }


}
