package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.VoucherCategories;

@Repository
public interface VoucherCategoriesRepository extends JpaRepository<VoucherCategories, Long> {

}
