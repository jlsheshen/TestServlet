package com.edu.web.servlet;

import com.edu.domain.PageModel;
import com.edu.domain.Product;
import com.edu.service.ProductService;
import com.edu.service.imp.ProductServiceImp;
import com.edu.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends BaseServlet {

     public String findProductById(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //获取pid
         String pid = req.getParameter("pid");
         ProductService productService = new ProductServiceImp();
         //查询商品信息
         Product product =productService.findProductById(pid);

         req.setAttribute("product",product);
        return "/jsp/product_info.jsp";
    }
    public String findProductsByCidWithPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取CID nUM
        String cid = req.getParameter("cid");
        int curNumber = Integer.parseInt(req.getParameter("num"));
        //调用业务层功能,以分页形式查询信息
        ProductService productService = new ProductServiceImp();
        PageModel pageModel =  productService.findProductsByCidWithPage(cid,curNumber);
        //返回pageMode对象
        req.setAttribute("page",pageModel);
        //讲page放入request
        //跳转到productList界面


        return "/jsp/product_list.jsp";
    }



}
