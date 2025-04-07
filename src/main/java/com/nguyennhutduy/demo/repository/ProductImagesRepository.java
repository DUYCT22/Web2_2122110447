package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

}
