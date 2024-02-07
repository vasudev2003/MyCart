package test;

import org.junit.Test;

import main.java.entities.Cart;
import main.java.entities.Product;
import main.java.services.CartService;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {
    @Test
    public void testAddToCart() {

        CartService cartService = new CartService();
        Product product = new Product("1", "Laptop", 1000);
        Cart cart= new Cart();

        cartService.addProductToCart(cart, product);


        assertEquals(2, cartService);
    }
}
