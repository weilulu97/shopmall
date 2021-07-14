package com.wll.service.impl;

import com.wll.domain.Category;
import com.wll.mapper.CategoryMapper;
import com.wll.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }

    @Override
    public Category queryCategoryById(int categoryId) {
        return categoryMapper.queryCategoryById(categoryId);
    }
}
