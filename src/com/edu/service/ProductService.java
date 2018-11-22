package com.edu.service;

import com.edu.domain.PageModel;
import com.edu.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getNews() throws Exception;
    List<Product> getHots()throws Exception;

    Product findProductById(String pid)throws Exception;
    PageModel findProductsByCidWithPage(String cid, int num)throws Exception;
}
