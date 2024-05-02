package com.example.productservice.service;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(Long id);

    public List<Product> getAllProduct();

    public void deleteProduct(Long id);

    public Product updateProduct(Product product,Long id);

    public Product replaceProduct(Product product,Long id);



}
