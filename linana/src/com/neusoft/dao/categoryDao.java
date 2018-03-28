package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;

public interface categoryDao {
public  List<Category> findAllCate();
public int deleteCateById(Integer id);
public int addCategory(Category category);
public PageModel<Category> findCatebyPage(int pageNo,int pageSize);
public Category findCateByid(Integer id);
public int updateCategory(Category category);
}
