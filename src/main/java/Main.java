package main.java;

import main.java.dbconfig.DatabaseConnection;
import main.java.entities.Bill;
import main.java.entities.Cart;
import main.java.entities.Product;
import main.java.entities.User;
import main.java.repositiories.BillRepository;
import main.java.repositiories.ProductRepository;
import main.java.repositiories.UserRepository;

import main.java.services.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            Connection connection = DatabaseConnection.getConnection();

            UserRepository userRepository = new UserRepository(connection);
            ProductRepository productRepository = new ProductRepository(connection);
            BillRepository billRepository = new BillRepository(connection);


            UserService userService = new UserService(userRepository);
            ProductService productService = new ProductService(productRepository);
            CartService cartService = new CartService();
            BillService billService = new BillService();
            AdminService adminService = new AdminService(productRepository, billRepository);
            adminService.addProduct("Electronics",new Product("1","watch",200));
            adminService.addProduct("Cloths",new Product("2","shirt",300));

            User user= new User("1","Vasudev");

            User user1 = userService.getUserById("user_id");
            List<String> categories = productService.getAllCategories();
            List<Product> products = productService.getAllProductsByCategory("category_name");
            Product product = productService.getProductById("product_id");
            Cart cart = new Cart();
            cartService.addProductToCart(cart, product);
            cartService.removeProductFromCart(cart, product);
            Bill userBill = billService.generateBill(user, cart); // Pass true to apply discount

            List<Product> adminProducts = adminService.getProductsByCategory("category_name");
            List<Bill> allBills = adminService.getAllBills();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
