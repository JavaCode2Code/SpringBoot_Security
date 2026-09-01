package com.example.demo.repository;

import com.example.demo.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByOwnerUsername(String username);
}
