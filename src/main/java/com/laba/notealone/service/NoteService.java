package com.laba.notealone.service;

import com.laba.notealone.entity.Note;
import com.laba.notealone.entity.User;
import com.laba.notealone.repo.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepo noteRepo;

    public void save(Note note) {
        noteRepo.save(note);
    }


    public Optional<Note> findByIdAndUser(Long id, User user) {
        return noteRepo.findByIdAndUser(id, user);
    }

    public List<Note> findByUser(User user) {
        return noteRepo.findByUser(user);
    }
}
