package ru.otus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.project.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
