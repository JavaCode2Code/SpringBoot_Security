package com.example.demo.service.impl;

import com.example.demo.model.Notes;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotesServiceImpl implements NotesService {


    @Autowired
    private NoteRepository noteRepo;


    @Override
    public Notes createNoteForUser(String username, String content) {
        // TODO Auto-generated method stub
        Notes notes = new Notes();
        notes.setContent(content);
        notes.setOwnerUsername(username);
        Notes saveNot = noteRepo.save(notes);
        return saveNot;
    }

    @Override
    public Notes updateNoteForuser(Long noteId, String content, String username) {
        // TODO Auto-generated method stub
        Notes notes = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        notes.setContent(content);
        notes.setOwnerUsername(username);
        return notes;
    }

    @Override
    public void deleteNotesForuser(Long noteId, String username) {
        // TODO Auto-generated method stub
        noteRepo.deleteById(noteId);

    }

    @Override
    public List<Notes> getNotesForUser(String userName) {
        // TODO Auto-generated method stub
        List<Notes> notList = noteRepo.findByOwnerUsername(userName);
        return notList;
    }

}
