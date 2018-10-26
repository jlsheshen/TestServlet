package com.edu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class ServletDemo01 extends HttpServlet {
    String path;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String md = request.getParameter("method");
        //使用反射方法
        Class clazz = this.getClass();
        try {
            Method method = clazz.getMethod(md,HttpServletRequest.class,HttpServletResponse.class);
            if (method != null) {
                 path = (String)method.invoke(this,request,response);
            }
            if (path != null){
                //服务端转发
                request.getRequestDispatcher(path).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //是使用键值配对
//        if ("addStu".equals(md)) {
//            addStu(request,response);
//        }else if ("delStu".equals(md)){
//            delStu(request,response);
//
//
//        }else if ("checkStu".equals(md)){
//            checkStu(request,response);
//
//        }else {
//            System.out.println("无此操作");
//        }
    }
    public String addStu(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加学生");
        return null;
    }
    public String delStu(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除学生");
        return null;

    }
    public String checkStu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("查找学生");
         response.getWriter().print("安睡的阿斯不好的");
        return null;

    }
}
