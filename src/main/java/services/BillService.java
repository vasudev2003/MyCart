package main.java.services;

import main.java.entities.Bill;
import main.java.entities.Cart;
import main.java.entities.Product;
import main.java.entities.User;

import java.util.List;

public class BillService {
    public Bill generateBill(User user, Cart cart) {
        List<Product> products = cart.getProducts();
        String userId= user.getId();
        double actualAmount = calculateActualAmount(products);
        double discountAmount = calculateDiscount(actualAmount);
        double finalAmount = actualAmount - discountAmount;

        Bill bill = new Bill(userId, products, discountAmount, finalAmount);
        return bill;
    }

    private double calculateActualAmount(List<Product> products) {
        double actualAmount = 0;
        for (Product product : products) {
            actualAmount += product.getPrice();
        }
        return actualAmount;
    }

    private double calculateDiscount(double actualAmount) {
        if (actualAmount > 10000) {
            return 500;
        } else {
            return 0;
        }
    }
}
