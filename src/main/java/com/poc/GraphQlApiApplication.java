package com.poc;

import com.poc.entity.Product;
import com.poc.repo.ProductRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphQlApiApplication {

    @Autowired
    private ProductRepo repo;

    @PostConstruct
    public void init_method(){
        List<Product> products = Stream.of(
                Product.builder().name("Iphone").stock(10).price(15000.00).category("electornics").build(),
                Product.builder().name("samsung").stock(100).price(16000.00).category("electornics").build(),
                Product.builder().name("nokia").stock(70).price(10000.00).category("electornics").build(),
                Product.builder().name("spanner").stock(132).price(100.00).category("hardware").build(),
                Product.builder().name("maagi").stock(90).price(200.00).category("food").build(),
                Product.builder().name("jammun").stock(40).price(1000.00).category("food").build()
        ).toList();

        repo.saveAll(products);

    }

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApiApplication.class, args);
	}

}
