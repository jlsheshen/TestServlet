package com.edu.service.imp;

import com.edu.dao.UserDao;
import com.edu.dao.imp.UserDaoImp;
import com.edu.domain.User;
import com.edu.service.UserService;

import java.sql.SQLException;

public class UserServiceImp implements UserService {
    @Override
    public boolean activiteCode(String code) throws SQLException {
        //实现注册功能
        UserDao userDao = new UserDaoImp();
        //对DB发送 select
        User user = userDao.userActivie(code);
        if (user == null) {
            //不可激活
            return false;

        }else {
            //根据激活码查询到了一个用户
            //修改状态码,清除激活码
            user.setCode(null);
            user.setState(1);
            //对数据库更新
            userDao.updateUser(user);
            return true;

        }
    }

    @Override
    public void userRegist(User user) throws Exception{
            //实现注册
        UserDao userDao = new UserDaoImp();
        userDao.userRegist(user);
    }

    @Override
    public User userLogin(User user) throws Exception {
        UserDao userDao = new UserDaoImp();
        User user1= userDao.userLogin(user);
        if (user1 == null){
            throw new RuntimeException("密码也不对呀" );

        }else if (user1.getState()==0){
            throw new RuntimeException("账号未激活" );

        }else {
                return user1;
        }
     }
}
