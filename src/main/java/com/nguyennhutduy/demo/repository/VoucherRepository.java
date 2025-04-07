package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

}
