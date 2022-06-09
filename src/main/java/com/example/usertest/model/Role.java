package com.example.usertest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(1L, "Admin"),
    USER(2L, "User");

    private Long id;
    private String name;

    public static Role getByName(String name) {
        return Arrays.stream(Role.values())
                .filter(role -> Objects.equals(role.name, name))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public static Role getById(Long id) {
        return Arrays.stream(Role.values())
                .filter(role -> Objects.equals(role.id, id))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
