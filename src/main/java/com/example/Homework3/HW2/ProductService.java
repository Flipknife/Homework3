package com.example.Homework3.HW2;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product save(Product product) {
        return (Product)this.productRepository.save(product);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        return (Product)this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product update(Long id, Product product) {
        Product existing = this.findById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        return (Product)this.productRepository.save(existing);
    }

    public Product create(Product product) {
        return product;
    }

    public Long delete(Long id) {
        return id;
    }
}
