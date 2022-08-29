package ru.otus.project.service;

import org.springframework.stereotype.Service;
import ru.otus.project.domain.Client;
import ru.otus.project.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
