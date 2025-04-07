package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Brand;

public interface BrandService {
    Brand createBrand(Brand brand);

    Brand getBrandById(Long brandId);

    List<Brand> getAllBrand();

    Brand updateBrand(Brand brand);

    void deleteBrand(Long brandId);
}
