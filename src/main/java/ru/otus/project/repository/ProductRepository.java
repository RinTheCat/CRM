package ru.otus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.project.domain.Product;
import ru.otus.project.domain.Order;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}