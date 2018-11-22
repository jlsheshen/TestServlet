package com.edu.web.servlet;


import com.edu.domain.Category;
import com.edu.domain.Product;
import com.edu.service.CategoryService;
import com.edu.service.ProductService;
import com.edu.service.imp.CategoryServiceImp;
import com.edu.service.imp.ProductServiceImp;
import com.edu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        //调用与业务层功能获取全部分类信息,返回集合
//        CategoryService categoryService = new CategoryServiceImp();
//        List<Category> categories = categoryService.getAllCats();
//        //将返回集合放进request中
//        req.setAttribute("allCats",categories);

        //调用业务层,查询最新 最热商品
        ProductService productService = new ProductServiceImp();
        List<Product> hots = productService.getHots();
        List<Product> news = productService.getNews();
        req.setAttribute("hots",hots);
        req.setAttribute("news",news);


        //将两个集合放入request中

        //转发回首页

        return "/jsp/index.jsp";
    }
}
