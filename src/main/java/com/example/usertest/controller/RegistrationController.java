package com.example.usertest.controller;

import com.example.usertest.form.RegistrationForm;
import com.example.usertest.model.Role;
import com.example.usertest.model.User;
import com.example.usertest.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegistrationController {

    @NonNull
    private final UserService userService;

    @GetMapping
    public String showRegister(Model model) {
        model.addAttribute("user", RegistrationForm.builder().build());
        return "register";
    }

    @PostMapping
    public String doRegister(RegistrationForm form) {
        User user = User.builder()
                .fullName(form.getFullName())
                .username(form.getUsername())
                .password(form.getPassword())
                .roles(List.of(Role.ADMIN))
                .build();
        userService.save(user);
        return "redirect:/";
    }
}
