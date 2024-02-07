package main.java.services;

import main.java.entities.Product;
import main.java.repositiories.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getAllCategories() {
        return productRepository.getAllCategories();
    }

    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId);
    }
}

