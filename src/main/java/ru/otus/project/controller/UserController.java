package ru.otus.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.dto.UserDto;
import ru.otus.project.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/api/username")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
