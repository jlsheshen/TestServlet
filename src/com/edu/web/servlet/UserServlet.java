package com.edu.web.servlet;

import com.edu.domain.User;
import com.edu.service.UserService;
import com.edu.service.imp.UserServiceImp;
import com.edu.utils.MyBeanUtils;
import com.edu.utils.UUIDUtils;
import com.edu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserServlet extends BaseServlet {

    public String registUI(HttpServletRequest request,HttpServletResponse response){

        return "/jsp/register.jsp";
        }
    public String loginUI(HttpServletRequest request,HttpServletResponse response){

        return "/jsp/login.jsp";
    }


    public String userRegist(HttpServletRequest request,HttpServletResponse response){
        //接受表单参数
        Map<String ,String[]> map = request.getParameterMap();

        User user = new User();
        MyBeanUtils.populate(user,map);
        System.out.println(user);
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
        //调用业务层注册功能
        UserService service = new UserServiceImp();
        try {
            service.userRegist(user);
            request.setAttribute("msg",user.getCode());
            return "/jsp/activity_code.jsp";

        } catch (Exception e) {
            request.setAttribute("msg","注册失败 ");

            e.printStackTrace();
            return "/jsp/info.jsp";

        }
        //遍历map中数据
//        Set<String> keySet = map.keySet();
//        Iterator<String> iterator = keySet.iterator();
//        while (iterator.hasNext()){
//            String string = iterator.next();
//            System.out.println(string);
//            String[] strings = map.get(string);
//            for (String s : strings) {
//                System.out.println(s);
//            }
//            System.out.println();
//
//        }


    }


    public String userLogin(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        //获取用户数据
        User user = new User();
        MyBeanUtils.populate(user,request.getParameterMap());

        //调用业务层登陆功能
        UserService service = new UserServiceImp();
        try {
            //select * from user where username=? and password=?
            user = service.userLogin(user);
            //登陆成功
            request.getSession().setAttribute("loginUser",user);
            response.sendRedirect("/index.jsp");
            return null;
        }catch (Exception e){
            //用户登陆失败
            System.out.println(e.getMessage());
            //向Request中放入失败的信息
            request.setAttribute("msg",e.getMessage());
            return "/jsp/login.jsp";
        }


    }
    public String userLogout(HttpServletRequest request,HttpServletResponse response) throws  Exception {
            request.getSession().invalidate();
        response.sendRedirect("/index.jsp");
        return null;
    }


        /**
         * 验证用户是否存在
         * @param request
         * @param response
         * @return
         * @throws SQLException
         */

        public String active(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        //获取激活码
        String code = request.getParameter("code");
        UserService userService = new UserServiceImp() ;
        //调用业务成激活功能

        boolean flag = userService.activiteCode(code);
        //信息提示

        if (flag) {
            request.setAttribute("msg","激活成功,请登录");
            return "/jsp/login.jsp";

        }else {
            request.setAttribute("msg","激活失败请重新激活");

            return "/jsp/info.jsp";

        }

    }



}
