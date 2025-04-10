package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Size;
import com.nguyennhutduy.demo.repository.SizeRepository;
import com.nguyennhutduy.demo.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public Size getSizeById(Long sizeId) {
        return sizeRepository.findById(
                sizeId)
                .orElseThrow(() -> new RuntimeException("Size with ID " + sizeId + " not found"));
    }

    @Override
    public List<Size> getAllSize() {
        return sizeRepository.findAll();
    }

    @Override
    public Size updateSize(Size size) {
        Size existingSize = sizeRepository.findById(size.getId())
                .orElseThrow(() -> new RuntimeException("Size not found"));

        if (size.getName() != null && !size.getName().equals(existingSize.getName())) {
            existingSize.setName(size.getName());
        }
        return sizeRepository.save(existingSize);
    }

    @Override
    public void deleteSize(Long sizeId) {
        if (!sizeRepository.existsById(sizeId)) {
            throw new RuntimeException("Size with ID " + sizeId + " not found");
        }
        sizeRepository.deleteById(sizeId);
    }

}
