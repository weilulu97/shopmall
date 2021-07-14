package com.wll.mapper;

import com.wll.domain.Category;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface CategoryMapper {

    List<Category> queryAllCategory();

    List<Category> queryCategoryByName(String category);

    Category queryCategoryById(int categoryId);
}
