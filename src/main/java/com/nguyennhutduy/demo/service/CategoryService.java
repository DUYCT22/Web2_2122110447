package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> createListCategory(List<Category> category);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategory();

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);
}
