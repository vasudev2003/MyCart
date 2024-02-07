package main.java.services;

import main.java.entities.Bill;
import main.java.entities.Product;

import main.java.repositiories.BillRepository;
import main.java.repositiories.ProductRepository;

import java.util.List;

public class AdminService {
    private ProductRepository productRepository;
    private BillRepository billRepository;

    public AdminService(ProductRepository productRepository, BillRepository billRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }

    public void addProduct(String category, Product product) {
        productRepository.addProduct(category, product);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Bill> getAllBills() {
        return billRepository.getAllBills();
    }
}
