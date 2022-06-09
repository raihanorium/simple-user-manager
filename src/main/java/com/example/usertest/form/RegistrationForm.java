package com.example.usertest.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationForm {
    private Long id;
    private String fullName;
    private String username;
    private String password;
}
