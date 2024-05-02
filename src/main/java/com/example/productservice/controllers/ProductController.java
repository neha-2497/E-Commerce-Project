package com.example.productservice.controllers;


import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProduct(){
        return new ArrayList<Product>();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @PostMapping("{id}")
    public Product replaceProduct(@RequestBody Product produc,@PathVariable("id") Long id){
        return new Product();
    }

    @PatchMapping("{id}")
    public Product updateProduct(@RequestBody Product produc,@PathVariable("id") Long id){
        return new Product();
    }


    @DeleteMapping("{id}")
    public void DeleteProductById(@PathVariable("id") Long id){

    }

}
