package com.poc.service;

import com.poc.entity.Product;
import com.poc.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepo repo;


    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public List<Product> getAllProductsByCategory(String category){
        return repo.findByCategory(category);
    }

    public Product saveProduct(Product product){
        return repo.save(product);
    }

    public Product updateProductStock(int id , int stock){
        Product existingProduct = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("product ID: "+id + " does not exists"));
        existingProduct.setStock(stock);
        return repo.save(existingProduct);
    }

    public String deleteProduct(int id){
        if(!repo.existsById(id)){
            throw new RuntimeException(id + " does not exists");
        }
        repo.deleteById(id);
        return String.format("product with ID:%d deleted!",id);
    }


}
