package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

}
