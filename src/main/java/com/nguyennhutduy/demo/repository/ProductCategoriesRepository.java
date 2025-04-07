package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.ProductCategories;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Long> {

}
