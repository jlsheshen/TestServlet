package com.edu.dao;

import com.edu.domain.Category;
import com.edu.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    List<Category> getAllCats()throws Exception;
}
