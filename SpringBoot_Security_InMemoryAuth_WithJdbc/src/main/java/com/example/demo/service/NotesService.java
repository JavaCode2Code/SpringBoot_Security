package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Notes;

public interface NotesService {
    Notes createNoteForUser(String username, String content);

    Notes updateNoteForuser(Long noteId, String content, String username);

    void deleteNotesForuser(Long noteId, String username);

    List<Notes> getNotesForUser(String userName);
}
