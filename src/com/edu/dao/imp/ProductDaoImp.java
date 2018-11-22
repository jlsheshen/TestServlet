package com.edu.dao.imp;

import com.edu.dao.ProductDao;
import com.edu.domain.Product;
import com.edu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> getNews() throws Exception {
        String sql = "select * from product where pflag = 0 order by pdate desc limit 0,9";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class));    }

    @Override
    public List<Product> getHots() throws Exception {
        String sql = "select * from product where pflag = 0 and is_hot = 1 order by pdate desc limit 0,9";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class));

    }

    @Override
    public Product findProductById(String pid) throws Exception {
        String sql = "select * from product where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
    }

    @Override
    public long getTotalRecord(String cid) throws Exception {
        String sql = "select count(*) from product where cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return (long) queryRunner.query(sql, new ScalarHandler(),cid);
    }

    @Override
    public List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws Exception {
        String sql = "select * from product where cid = ? limit ?,?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return  queryRunner.query(sql,new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);
    }


}
