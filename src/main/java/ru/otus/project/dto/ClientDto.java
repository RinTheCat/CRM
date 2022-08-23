package ru.otus.project.dto;

import ru.otus.project.domain.Client;

public class ClientDto {

    private String clientName;

    public ClientDto(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Client toDomainObject() {
        return null;
    }

    public static ClientDto toDto(Client client) {
        return new ClientDto(client.getName());
    }
}
