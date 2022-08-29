package ru.otus.project.service;

import org.springframework.stereotype.Service;
import ru.otus.project.domain.Product;
import ru.otus.project.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
