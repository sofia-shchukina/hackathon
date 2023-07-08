package com.example.hackathon;

import com.example.hackathon.products.Product;
import com.example.hackathon.products.ProductService;
import com.example.hackathon.users.Customer;
import com.example.hackathon.users.CustomerService;
import com.example.hackathon.util.JsonDataHandler;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;


@SpringBootApplication
public class SocialShoppingApplication {


    public static void main(String[] args) {


        SpringApplication app = new SpringApplication(SocialShoppingApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        ApplicationContext context = app.run(args);

        JsonDataHandler jsonDataHandler = new JsonDataHandler();

        // Parsing and saving customers
        String customersFileName = "Customers.json";
        parseAndSaveCustomers(jsonDataHandler, customersFileName, context);

        // Parsing and saving products
        String productsFileName = "Products.json";
        parseAndSaveProducts(jsonDataHandler, productsFileName, context);
    }

    private static void parseAndSaveCustomers(JsonDataHandler jsonDataHandler, String fileName, ApplicationContext context) {
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            byte[] fileContent = StreamUtils.copyToByteArray(resource.getInputStream());
            String jsonData = new String(fileContent, StandardCharsets.UTF_8);
            List<Customer> parsedCustomers = jsonDataHandler.readJsonDataForCustomers(jsonData);

            CustomerService customerService = context.getBean(CustomerService.class);

            customerService.saveAllCustomers(parsedCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseAndSaveProducts(JsonDataHandler jsonDataHandler, String fileName, ApplicationContext context) {
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            byte[] fileContent = StreamUtils.copyToByteArray(resource.getInputStream());
            String jsonData = new String(fileContent, StandardCharsets.UTF_8);
            List<Product> parsedProducts = jsonDataHandler.readJsonDataForProducts(jsonData);

            ProductService productService = context.getBean(ProductService.class);

            productService.saveAllProducts(parsedProducts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



