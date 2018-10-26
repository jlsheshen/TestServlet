package com.edu.dao.imp;

import com.edu.dao.CategoryDao;
import com.edu.domain.Category;
import com.edu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public List<Category> getAllCats() throws Exception {
        String sql = "select * from category";
        QueryRunner queryRunner  =  new QueryRunner(JDBCUtils.getDataSource());


        return queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
    }
}
