package com.wll.service;

import com.wll.domain.Category;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface CategoryService {

    List<Category> queryAllCategory();

    Category queryCategoryById(int categoryId);
}
