package com.edu.service.imp;

import com.edu.dao.CategoryDao;
import com.edu.dao.imp.CategoryDaoImp;
import com.edu.domain.Category;
import com.edu.service.CategoryService;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    @Override
    public List<Category> getAllCats() throws Exception {
        CategoryDao categoryDao = new CategoryDaoImp();
        List<Category> categories = categoryDao.getAllCats();
        return categories;
    }
}
