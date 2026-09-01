package com.example.demo.service;

import com.example.demo.model.Notes;

import java.util.List;

public interface NotesService {
    Notes createNoteForUser(String username, String content);

    Notes updateNoteForuser(Long noteId, String content, String username);

    void deleteNotesForuser(Long noteId, String username);

    List<Notes> getNotesForUser(String userName);
}
