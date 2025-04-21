package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Size;

public interface SizeService {
    Size createSize(Size size);

    List<Size> createListSize(List<Size> size);

    Size getSizeById(Long sizeId);

    List<Size> getAllSize();

    Size updateSize(Size size);

    void deleteSize(Long sizeId);
}
