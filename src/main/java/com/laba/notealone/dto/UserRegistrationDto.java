package com.laba.notealone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationDto {
    private String email;
    private String password;
    private String first_name;
    private String last_name;
}
