package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Product;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> createListProduct(List<Product> product);

    Product getProductById(Long productId);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}
