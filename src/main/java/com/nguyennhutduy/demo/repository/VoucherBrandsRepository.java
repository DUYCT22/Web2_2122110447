package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.VoucherBrands;

@Repository
public interface VoucherBrandsRepository extends JpaRepository<VoucherBrands, Long> {

}
