package main.java.services;

import main.java.entities.Cart;
import main.java.entities.Product;

public class CartService {
    public void addProductToCart(Cart cart, Product product) {
        cart.addProduct(product);
    }

    public void removeProductFromCart(Cart cart, Product product) {
        cart.removeProduct(product);
    }

}
