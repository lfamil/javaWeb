package com.neusoft.serviceImp;

import java.util.List;

import com.neusoft.dao.categoryDao;
import com.neusoft.daoImp.CategorydaoImpl;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> findAllCate() {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.findAllCate();
	}

	@Override
	public PageModel<Category> findCatebyPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.findCatebyPage(pageNo, pageSize);
	}

	@Override
	public int deleteCateById(Integer id) {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.deleteCateById(id);
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.addCategory(category);
	}

	@Override
	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.findCateByid(id);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao cate=CategorydaoImpl.getInstance();
		return cate.updateCategory(category);
	}

}
