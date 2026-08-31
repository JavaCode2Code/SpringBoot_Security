package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Notes;

public interface NoteRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByOwnerUsername(String username);
}
