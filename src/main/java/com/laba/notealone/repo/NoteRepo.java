package com.laba.notealone.repo;

import com.laba.notealone.entity.Note;
import com.laba.notealone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
    public Optional<Note> findByIdAndUser(Long id, User user);

    public List<Note> findByUser(User user);
}
