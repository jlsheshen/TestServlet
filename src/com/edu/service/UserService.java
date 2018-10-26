package com.edu.service;

import com.edu.domain.User;

import java.sql.SQLException;

public interface UserService {
   boolean activiteCode(String code) throws SQLException;

   void userRegist(User user) throws Exception;

   User userLogin(User user)throws Exception;
}
