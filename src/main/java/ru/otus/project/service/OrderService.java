package ru.otus.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.project.domain.Comment;
import ru.otus.project.domain.Order;
import ru.otus.project.domain.OrderProductKey;
import ru.otus.project.domain.Product;
import ru.otus.project.domain.ProductQuantity;
import ru.otus.project.domain.Status;
import ru.otus.project.repository.CommentRepository;
import ru.otus.project.repository.OrderRepository;
import ru.otus.project.repository.ProductQuantityRepository;
import ru.otus.project.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProductQuantityRepository productQuantityRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, ProductQuantityRepository productQuantityRepository, CommentRepository commentRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productQuantityRepository = productQuantityRepository;
        this.commentRepository = commentRepository;
    }

    public Long count() {
        return orderRepository.count();
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public Order getById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        return order.get();
    }

    @Transactional
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public void pushStatus(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        order.get().setNextStatus();
        orderRepository.save(order.get());
    }

    @Transactional
    public void pullStatus(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        order.get().setPreviousStatus();
        orderRepository.save(order.get());
    }

    @Transactional
    public void cancelStatus(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        order.get().cancelOrder();
        orderRepository.save(order.get());
    }

    @Transactional
    public void addProductQuantity(long id, long productId, int newQuantity) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        for (ProductQuantity productQuantity : order.get().getProductQuantities()) {
            if (productQuantity.getProduct().getId() == productId) {
                productQuantity.setQuantity(newQuantity);
            }
        }
    }

    @Transactional
    public void addNewProduct(long id, String productName, int quantity) {
        Optional<Order> order = orderRepository.findById(id);
        Optional<Product> product = productRepository.findByName(productName);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        if (product.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", productName));
        Order orderToEdit = order.get();
        Product productToEdit = product.get();
        ProductQuantity productQuantity = new ProductQuantity(new OrderProductKey(orderToEdit.getId(), productToEdit.getId()),
                orderToEdit, productToEdit, quantity);
        orderToEdit.getProductQuantities().add(productQuantity);
        productQuantityRepository.save(productQuantity);
    }

    @Transactional
    public void addNewComment(long id, String text) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        Comment comment = new Comment(0, order.get(), text);
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteProduct(long orderId, long productId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", orderId));

        for (ProductQuantity productQuantity : order.get().getProductQuantities()) {
            if (productQuantity.getProduct().getId() == productId) {
                productQuantityRepository.deleteById(productQuantity.getId());
            }
        }

    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Order> getAllByStatus(Status status) {
        return orderRepository.findAllByStatus(status);
    }
}
