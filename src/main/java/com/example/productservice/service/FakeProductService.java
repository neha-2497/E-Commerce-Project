package com.example.productservice.service;

import com.example.productservice.dtos.FakeProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProduct(Long id) {
        FakeProductDto fakeProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeProductDto.class);
        return convertDtoToProduct(fakeProductDto);
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
        return null;
    }

    // Converts a FakeStoreProductDto to a Product object
    private Product convertDtoToProduct(FakeProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        Category category = new Category();
        category.setId(0);
        category.setTitle(dto.getCategory());

        product.setCategory(category);

        return product;
    }
}
