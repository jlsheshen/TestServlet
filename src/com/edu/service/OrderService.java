package com.edu.service;


import com.edu.domain.Order;
import com.edu.domain.PageModel;
import com.edu.domain.User;

public interface OrderService {

	void saveOrder(Order order)throws Exception;

	PageModel findMyOrdersWithPage(User user, int curNum)throws Exception;

	Order findOrderByOid(String oid)throws Exception;

	void updateOrder(Order order)throws Exception;

}
