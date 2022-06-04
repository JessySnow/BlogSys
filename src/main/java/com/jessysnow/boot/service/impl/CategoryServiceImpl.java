package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.Category;
import com.jessysnow.boot.mapper.CategoryMapper;
import com.jessysnow.boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public boolean checkCategoryAlreadyIn(String value) {
        return categoryMapper.selectCategoryByValue(value) != null;
    }

    @Override
    public int addANewCategory(String value) {
        Category category = new Category();
        category.setValue(value);
        categoryMapper.insertANewCategory(category);
        return category.getId();
    }

    @Override
    public Category getCategoryByValue(String value) {
        return categoryMapper.selectCategoryByValue(value);
    }

    @Override
    public int addOrGetCategory(String value) {
        if(checkCategoryAlreadyIn(value)) {
            return getCategoryByValue(value).getId();
        }
        else
            return addANewCategory(value);
    }
}
