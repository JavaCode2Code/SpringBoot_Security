package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notes;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Notes createNoteForUser(String username, String content) {
		// TODO Auto-generated method stub
		Notes notes = new Notes();
		notes.setContent(content);
		notes.setOwnerUsername(username);
		Notes saveNot = noteRepository.save(notes);
		return saveNot;
	}

	@Override
	public Notes updateNoteForuser(Long noteId, String content, String username) {
		// TODO Auto-generated method stub
		Notes notes=noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note not found"));
		notes.setContent(content);
		notes.setOwnerUsername(username);
		return notes;
	}

	@Override
	public void deleteNotesForuser(Long noteId, String username) {
		// TODO Auto-generated method stub
		noteRepository.deleteById(noteId);

	}

	@Override
	public List<Notes> getNotesForUser(String userName) {
		// TODO Auto-generated method stub
		List<Notes> notList = noteRepository.findByOwnerUsername(userName);
		return notList;
	}

}
