package com.edu.service.imp;

import com.edu.dao.ProductDao;
import com.edu.dao.imp.ProductDaoImp;
import com.edu.domain.PageModel;
import com.edu.domain.Product;
import com.edu.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService {

    ProductDao productDao = new ProductDaoImp();

    @Override
    public List<Product> getNews() throws Exception {

        return productDao.getNews();
    }

    @Override
    public List<Product> getHots() throws Exception {
        return productDao.getHots();
    }

    @Override
    public Product findProductById(String pid) throws Exception {
        return productDao.findProductById(pid);
    }

    @Override
    public PageModel findProductsByCidWithPage(String cid, int num) throws Exception {

        //创建pagemodel对象:计算分页参数
        ProductDao productDao = new ProductDaoImp();
        int totalRecord = (int) productDao.getTotalRecord(cid);
        PageModel pageModel = new PageModel(num,totalRecord,12);
        //关联集合
         List list =  productDao.findProductsByCidWithPage(cid,pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("ProductServlet?method=findProductsByCidWithPage&cid=" + cid);
        return pageModel;
    }
}
