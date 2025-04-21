package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.ProductImages;

public interface ProductImageService {
    ProductImages createProductImage(ProductImages productImage);

    List<ProductImages> createListProductImage(List<ProductImages> productImage);

    ProductImages getProductImageById(Long productImageId);

    List<ProductImages> getAllProductImage();

    ProductImages updateProductImage(ProductImages productImage);

    void deleteProductImage(Long productImageId);
}
