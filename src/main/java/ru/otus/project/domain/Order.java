package ru.otus.project.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User clientManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ProductQuantity> productQuantities;

    @OneToMany(orphanRemoval = true, mappedBy = "order", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Order() {
    }

    public Order(long id, Status status, User clientManager, Client client, List<ProductQuantity> productQuantities, List<Comment> comments) {
        this.id = id;
        this.status = status;
        this.clientManager = clientManager;
        this.client = client;
        this.productQuantities = productQuantities;
        this.comments = comments;
    }

    public void setPreviousStatus() {
        this.setStatus(status.prev());
    }

    public void setNextStatus() {
        this.setStatus(status.next());
    }

    public void cancelOrder() {
        this.setStatus(status.cancel());
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

    public User getClientManager() {
        return clientManager;
    }

    public void setClientManager(User clientManager) {
        this.clientManager = clientManager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(List<ProductQuantity> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", status=" + status +
//                ", clientManager=" + clientManager +
//                ", client=" + client +
//                ", productQuantities=" + productQuantities +
//                '}';
//    }
}
