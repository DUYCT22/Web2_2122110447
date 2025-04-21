package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Product;
import com.nguyennhutduy.demo.repository.ProductRepository;
import com.nguyennhutduy.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with ID " + productId + " not found"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getCategory() != null && !product.getCategory().equals(existingProduct.getCategory())) {
            existingProduct.setCategory(product.getCategory());
        }
        if (product.getName() != null && !product.getName().equals(existingProduct.getName())) {
            existingProduct.setName(product.getName());
        }
        if (product.getDetail() != null && !product.getDetail().equals(existingProduct.getDetail())) {
            existingProduct.setDetail(product.getDetail());
        }
        if (product.getSlug() != null && !product.getSlug().equals(existingProduct.getSlug())) {
            existingProduct.setSlug(product.getSlug());
        }
        if (product.getSellingPrice() != 0 && product.getSellingPrice() != existingProduct.getSellingPrice()) {
            existingProduct.setSellingPrice(product.getSellingPrice());
        }
        if (product.getSold() != 0 && product.getSold() != existingProduct.getSold()) {
            existingProduct.setSold(product.getSold());
        }
        if (product.getStatus() != 0 && product.getStatus() != existingProduct.getStatus()) {
            existingProduct.setStatus(product.getStatus());
        }
        existingProduct.setUpdatedBy(product.getUpdatedBy());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product with ID " + productId + " not found");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> createListProduct(List<Product> product) {
        return productRepository.saveAll(product);
    }

}
