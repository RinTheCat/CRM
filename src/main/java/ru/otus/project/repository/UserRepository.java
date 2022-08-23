package ru.otus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.project.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
