package ru.otus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.project.domain.ProductQuantity;

public interface ProductQuantityRepository  extends JpaRepository<ProductQuantity, Long> {
}
