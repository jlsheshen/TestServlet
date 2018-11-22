package com.edu.dao;

import com.edu.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getNews() throws Exception;
    List<Product> getHots() throws Exception;

    Product findProductById(String pid)throws Exception;

    long getTotalRecord(String cid )throws Exception;

    List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException, Exception;
}
