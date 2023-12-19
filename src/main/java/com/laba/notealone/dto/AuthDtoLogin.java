package com.laba.notealone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDtoLogin {
    private String email;
    private String password;
}
