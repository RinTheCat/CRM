package ru.otus.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.project.dto.OrderDto;
import ru.otus.project.service.OrderService;

@Controller
public class PageController {

    private final OrderService orderService;

    public PageController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String listPage() {
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable long id) {
        model.addAttribute("order", OrderDto.toDto(orderService.getById(id)));
        return "edit";
    }
}
