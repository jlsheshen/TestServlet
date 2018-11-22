package com.edu.web.servlet;

import com.edu.domain.Category;
import com.edu.service.CategoryService;
import com.edu.service.imp.CategoryServiceImp;
import com.edu.utils.JedisUtils;
import com.edu.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryServlet extends BaseServlet {

     public String getAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {
         String jsonStr;
         //在redis 中获取全部分类
         Jedis jedis =  JedisUtils.getJedis();
           jsonStr = jedis.get("allCats");
           //如果没有缓存中没有
         if (jsonStr == null||"".equals(jsonStr)) {
             System.out.println("缓存中没有数据");

             //调用与业务层功能获取全部分类信息,返回集合
             CategoryService categoryService = new CategoryServiceImp();
             List<Category> categories = categoryService.getAllCats();
             //将数据放入缓存
             jsonStr= JSONArray.fromObject(categories).toString();
             jedis.set("allCats",jsonStr);


         }
         JedisUtils.closeJedis(jedis);
         //告诉浏览器本次是json格式 UTF-8
         resp.setContentType("application/json;charset=utf-8");
         resp.getWriter().print(jsonStr);

         System.out.println(jsonStr);



        return null;
    }

}
