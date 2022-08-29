package ru.otus.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.dto.ClientDto;
import ru.otus.project.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/clients")
    public List<ClientDto> getClients() {
        return clientService.getAll().stream().map(ClientDto::toDto).collect(Collectors.toList());
    }
}