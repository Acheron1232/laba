package com.laba.notealone;

import com.laba.notealone.entity.Note;
import com.laba.notealone.entity.User;
import com.laba.notealone.repo.NoteRepo;
import com.laba.notealone.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NoteAloneApplicationTests {
    @Autowired
    UserRepo userRepo;

    @Test
    void contextLoads() {
        List<User> userByEmail = userRepo.findAll();
        System.out.println(userByEmail);
    }

}
