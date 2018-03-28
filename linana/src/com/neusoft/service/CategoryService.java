package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;

public interface CategoryService {
public List<Category> findAllCate();
public PageModel<Category> findCatebyPage(int pageNo, int pageSize);
public int deleteCateById(Integer id);
public int addCategory(Category category);
public Category findCategoryById(Integer id);
public int updateCategory(Category category);
}
