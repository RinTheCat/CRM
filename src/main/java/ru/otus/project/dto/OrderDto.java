package ru.otus.project.dto;

import ru.otus.project.domain.Comment;
import ru.otus.project.domain.Order;
import ru.otus.project.domain.ProductQuantity;
import ru.otus.project.domain.Status;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderDto {

    private long id;

    private Status status;
    
    private String user;
    
    private String client;

    private List<CommentDto> comments;

    private List<ProductQuantityDto> quantities;

    public OrderDto() {
    }

    public OrderDto(long id, Status status, String user, String client, List<ProductQuantityDto> quantities, List<CommentDto> comments) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.client = client;
        this.quantities = quantities;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<ProductQuantityDto> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<ProductQuantityDto> quantities) {
        this.quantities = quantities;
    }

    public Order toDomainObject() {
        return null;
    }

    public static OrderDto toDto(Order order) {
        return new OrderDto(order.getId(),
                order.getStatus(),
                order.getClientManager().getUsername(),
                order.getClient().getName(),
                order.getProductQuantities().stream().map(ProductQuantityDto::toDto).collect(Collectors.toList()),
                order.getComments().stream().map(CommentDto::toDto).collect(Collectors.toList()));
    }
}
