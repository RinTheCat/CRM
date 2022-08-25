package ru.otus.project.controller;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.domain.Status;
import ru.otus.project.dto.OrderDto;
import ru.otus.project.service.OrderService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostFilter("filterObject.user == authentication.name or hasRole('HEAD_MANAGER')")
    @GetMapping("/api/orders")
    public List<OrderDto> getOrders() {
        return orderService.getAll().stream().map(OrderDto::toDto)
                .collect(Collectors.toList());
    }

    @PostFilter("filterObject.user == authentication.name or hasRole('HEAD_MANAGER')")
    @GetMapping(value = "/api/orders", params = "status")
    public List<OrderDto> getOrdersByStatus(@RequestParam String status) {
        return orderService.getAllByStatus(Status.valueOf(status)).stream().map(OrderDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/order/{id}")
    public OrderDto getOrder(@PathVariable long id) {
        return OrderDto.toDto(orderService.getById(id));
    }

    @PostMapping("/api/order")
    public long create(Principal principle) {
        return orderService.createNewProduct(principle.getName());
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteById(id);
    }

    @PostMapping("/api/order/{id}/product/{productName}")
    public void addProduct(@PathVariable long id, @PathVariable String productName, @RequestParam int quantity) {
        orderService.addNewProduct(id, productName, quantity);
    }

    @PutMapping("/api/order/{id}/product/{productId}")
    public void changeProductQuantity(@PathVariable long id, @PathVariable long productId, @RequestParam int quantity) {
        orderService.addProductQuantity(id, productId, quantity);
    }

    @DeleteMapping("/api/order/{id}/product/{productId}")
    public void deleteProduct(@PathVariable long id, @PathVariable long productId) {
        orderService.deleteProduct(id, productId);
    }

    @PutMapping("/api/order/{id}/status/push")
    public void pushStatus(@PathVariable long id) {
        orderService.pushStatus(id);
    }

    @PutMapping("/api/order/{id}/status/pull")
    public void pullStatus(@PathVariable long id) {
        orderService.pullStatus(id);
    }

    @PutMapping("/api/order/{id}/status/cancel")
    public void cancelStatus(@PathVariable long id) {
        orderService.cancelStatus(id);
    }

    @PostMapping("/api/order/{id}/comment")
    public void addComment(@PathVariable long id, @RequestParam String text) {
        orderService.addNewComment(id, text);
    }

    @PreAuthorize("hasRole('HEAD_MANAGER')")
    @PutMapping("/api/order/{id}/user")
    public void changeUser(@PathVariable long id, @RequestParam String userName) {
        orderService.changeUser(id, userName);
    }

    @PutMapping("/api/order/{id}/client")
    public void changeClient(@PathVariable long id, @RequestParam String clientName) {
        orderService.changeClient(id, clientName);
    }
}
