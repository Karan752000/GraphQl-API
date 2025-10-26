package com.poc.controller;

import com.poc.entity.Product;
import com.poc.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl service;

//    @GetMapping
    @QueryMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

//    @GetMapping("/{category}")
    @QueryMapping
    public List<Product> getAllProductsByCategoty(@Argument String category){
        return service.getAllProductsByCategory(category);
    }

    @MutationMapping
    public Product saveProduct(@Argument String name,
                               @Argument String category,
                               @Argument double price,
                               @Argument int stock){

        return service.saveProduct(Product.builder()
                .name(name)
                .category(category)
                .price(price)
                .stock(stock)
                .build());
    }

    @MutationMapping
    public Product updateProductStock(@Argument int id, @Argument int stock){
        return service.updateProductStock(id,stock);
    }

    @MutationMapping
    public String deleteProduct(@Argument int id){
        return service.deleteProduct(id);
    }


}
