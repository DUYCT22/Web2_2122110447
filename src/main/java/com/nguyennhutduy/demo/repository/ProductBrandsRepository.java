package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.ProductBrands;

@Repository
public interface ProductBrandsRepository extends JpaRepository<ProductBrands, Long> {

}
