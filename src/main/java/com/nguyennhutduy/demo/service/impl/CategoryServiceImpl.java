package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Category;
import com.nguyennhutduy.demo.repository.CategoryRepository;
import com.nguyennhutduy.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category with ID " + categoryId + " not found"));
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (category.getName() != null && !category.getName().equals(existingCategory.getName())) {
            existingCategory.setName(category.getName());
        }
        if (category.getSlug() != null && !category.getSlug().equals(existingCategory.getSlug())) {
            existingCategory.setSlug(category.getSlug());
        }
        existingCategory.setUpdatedBy(category.getUpdatedBy());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new RuntimeException("Category with ID " + categoryId + " not found");
        }
        categoryRepository.deleteById(categoryId);
    }

}
