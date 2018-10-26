//package com.edu.web.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//
//public class BaseServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = null;
//        String md = request.getParameter("method");
//        //使用反射方法
//        Class clazz = this.getClass();
//        try {
//            Method method = clazz.getMethod(md,HttpServletRequest.class,HttpServletResponse.class);
//            if (method != null) {
//                path = (String)method.invoke(this,request,response);
//            }
//            if (path != null){
//                //服务端转发
//                request.getRequestDispatcher(path).forward(request,response);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
