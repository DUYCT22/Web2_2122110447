package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Brand;
import com.nguyennhutduy.demo.repository.BrandRepository;
import com.nguyennhutduy.demo.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand with ID " + brandId + " not found"));
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        if (brand.getName() != null && !brand.getName().equals(existingBrand.getName())) {
            existingBrand.setName(brand.getName());
        }
        if (brand.getSlug() != null && !brand.getSlug().equals(existingBrand.getSlug())) {
            existingBrand.setSlug(brand.getSlug());
        }
        existingBrand.setUpdatedBy(brand.getUpdatedBy());
        return brandRepository.save(existingBrand);
    }

    @Override
    public void deleteBrand(Long brandId) {
        if (!brandRepository.existsById(brandId)) {
            throw new RuntimeException("Brand with ID " + brandId + " not found");
        }
        brandRepository.deleteById(brandId);
    }
}
