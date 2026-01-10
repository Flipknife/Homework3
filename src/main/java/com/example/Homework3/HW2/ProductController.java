package com.example.Homework3.HW2;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/products"})
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return this.service.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return this.service.findAll();
    }

    @GetMapping({"/{id}"})
    public Product getById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PutMapping({"/{id}"})
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return this.service.update(id, product);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
