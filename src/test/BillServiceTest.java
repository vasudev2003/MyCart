package test;

import org.junit.Test;

import main.java.entities.Bill;
import main.java.entities.Cart;
import main.java.entities.Product;
import main.java.entities.User;
import main.java.repositiories.ProductRepository;
import main.java.services.BillService;
import main.java.services.CartService;
import main.java.services.ProductService;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BillServiceTest  {
    @Test
    public void testGenerateBill() {
        Connection connection=null;

        CartService cartService = new CartService();
        ProductService productService = new ProductService(new ProductRepository(connection));
        Cart cart= new Cart();
        Product product = productService.getProductById("1");
        cartService.addProductToCart(cart, product);
        BillService billService=new BillService();


        Bill bill = billService.generateBill(new User("1","vasu"),cart);

        assertNotNull(bill);
        assertEquals(2000, bill.getTotalAmount());
        assertEquals(2000, bill.getDiscountedAmount());
    }

}
