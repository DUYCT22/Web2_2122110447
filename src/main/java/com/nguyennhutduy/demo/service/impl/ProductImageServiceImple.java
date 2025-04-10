package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.ProductImages;
import com.nguyennhutduy.demo.repository.ProductImagesRepository;
import com.nguyennhutduy.demo.service.ProductImageService;

@Service
public class ProductImageServiceImple implements ProductImageService {
    private final ProductImagesRepository productImagesRepository;

    public ProductImageServiceImple(ProductImagesRepository productImagesRepository) {
        this.productImagesRepository = productImagesRepository;
    }

    @Override
    public ProductImages createProductImage(ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    @Override
    public ProductImages getProductImageById(Long productImageId) {
        return productImagesRepository.findById(
                productImageId)
                .orElseThrow(() -> new RuntimeException("ProductImage with ID " + productImageId + " not found"));
    }

    @Override
    public List<ProductImages> getAllProductImage() {
        return productImagesRepository.findAll();
    }

    @Override
    public ProductImages updateProductImage(ProductImages productImage) {
        ProductImages existingProductImage = productImagesRepository.findById(productImage.getId())
                .orElseThrow(() -> new RuntimeException("ProductImage not found"));
        if (productImage.getProduct() != null && !productImage.getProduct().equals(existingProductImage.getProduct())) {
            existingProductImage.setProduct(productImage.getProduct());
        }
        if (productImage.getUrl() != null && !productImage.getUrl().equals(existingProductImage.getUrl())) {
            existingProductImage.setUrl(productImage.getUrl());
        }
        return productImagesRepository.save(existingProductImage);
    }

    @Override
    public void deleteProductImage(Long productImageId) {
        if (!productImagesRepository.existsById(productImageId)) {
            throw new RuntimeException("ProductImage with ID " + productImageId + " not found");
        }
        productImagesRepository.deleteById(productImageId);
    }

}
