package ru.otus.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.domain.Status;

@RestController
public class StatusController {

    @GetMapping("/api/statuses")
    public Status[] getOrders() {
        return Status.values();
    }
}
