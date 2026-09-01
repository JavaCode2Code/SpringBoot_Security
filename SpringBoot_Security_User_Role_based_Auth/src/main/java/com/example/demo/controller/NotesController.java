package com.example.demo.controller;

import com.example.demo.model.Notes;
import com.example.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/createNotes")
    public Notes createNotes(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String userName = userDetails.getUsername();
        System.out.println("username" + userName);
        return notesService.createNoteForUser(userName, content);
    }

    @GetMapping("/getUser")
    public List<Notes> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String user = userDetails.getUsername();
        System.out.println("User Details" + user);
        return notesService.getNotesForUser(user);
    }

    @PutMapping("/{noteId}")
    public Notes updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String userName = userDetails.getUsername();
        return notesService.updateNoteForuser(noteId, content, userName);
    }

    @DeleteMapping("/{noteId}")
    public void DeleteNote(@PathVariable Long noteId,
                           @AuthenticationPrincipal UserDetails userDetails) {
        String userName = userDetails.getUsername();
        notesService.deleteNotesForuser(noteId, userName);
    }
}
