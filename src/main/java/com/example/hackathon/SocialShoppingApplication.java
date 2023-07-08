package com.example.hackathon;

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
		String fileName = "Customers.json";

		try {
			ClassPathResource resource = new ClassPathResource(fileName);
			byte[] fileContent = StreamUtils.copyToByteArray(resource.getInputStream());
			String jsonData = new String(fileContent, StandardCharsets.UTF_8);
			List<Customer> parsedCustomers = jsonDataHandler.readJsonData(jsonData);

			CustomerService customerService = context.getBean(CustomerService.class);

			// Call the saveAll method of CustomerService to save the parsed customers
			customerService.saveAllCustomers(parsedCustomers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



