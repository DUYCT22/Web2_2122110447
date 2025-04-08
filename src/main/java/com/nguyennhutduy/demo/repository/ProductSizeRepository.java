package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.ProductSize;
@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {

}
