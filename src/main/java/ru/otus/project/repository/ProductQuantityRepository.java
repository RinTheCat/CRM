package ru.otus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.project.domain.Order;
import ru.otus.project.domain.OrderProductKey;
import ru.otus.project.domain.ProductQuantity;

import java.util.List;

public interface ProductQuantityRepository  extends JpaRepository<ProductQuantity, OrderProductKey> {
    List<ProductQuantity> findByOrder(Order order);
}
