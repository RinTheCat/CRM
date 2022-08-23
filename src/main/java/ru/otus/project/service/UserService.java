package ru.otus.project.service;

import org.springframework.stereotype.Service;
import ru.otus.project.domain.User;
import ru.otus.project.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
