package com.laba.notealone.controller;

import com.laba.notealone.dto.Message;
import com.laba.notealone.dto.NoteDto;
import com.laba.notealone.entity.Note;
import com.laba.notealone.entity.User;
import com.laba.notealone.service.NoteService;
import com.laba.notealone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllNote(Principal principal) {
        List<Note> all = noteService.findByUser(userService.findByEmail(principal.getName()).orElseThrow());
        return ResponseEntity.ok(all);
    }

    @PostMapping("/save")
    public String save(@RequestBody NoteDto data, Principal principal) {
        Optional<User> user = userService.findByEmail(principal.getName());
        noteService.save(new Note(null, data.getData(), LocalDateTime.now(), user.orElseThrow(() -> new UsernameNotFoundException("no login"))));
        return "redirect://note/all";
    }

    @PostMapping("/message")
    public ResponseEntity<?> send(@RequestBody Message message, Principal principal) {
        System.out.println(message);
        System.out.println(principal);
        Note note = noteService.findByIdAndUser(Long.valueOf(message.getNote_id()), userService.findByEmail(principal.getName()).orElseThrow()).orElseThrow();
        noteService.save(new Note(null, note.getContent(), LocalDateTime.now(), userService.findByEmail(message.getTo()).orElseThrow()));
        return ResponseEntity.ok("OK");
    }
}
