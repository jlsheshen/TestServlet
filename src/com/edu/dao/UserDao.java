package com.edu.dao;

import com.edu.domain.User;

import java.sql.SQLException;

public interface UserDao {
    User userActivie(String code) throws SQLException;

    void userRegist(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    User userLogin(User user)throws SQLException;
}
