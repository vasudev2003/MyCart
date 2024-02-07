package test;

import org.junit.Test;

import main.java.entities.Product;
import main.java.repositiories.ProductRepository;
import main.java.services.ProductService;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {

    @Test
    public void testAddProduct() {
         Connection connection=null;
        ProductRepository productRepository = new ProductRepository(connection);
        ProductService productService = new ProductService(productRepository);
        Product product = new Product("1", "Laptop", 1000);


        productService.getAllCategories();
        Product retrievedProduct = productService.getProductById("1");


        assertEquals(product, retrievedProduct);
    }

}