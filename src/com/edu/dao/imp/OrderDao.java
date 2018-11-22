package com.edu.dao.imp;

import com.edu.domain.Order;
import com.edu.domain.OrderItem;
import com.edu.domain.User;

import java.sql.Connection;
import java.util.List;



public interface OrderDao {

	void saveOrder(Connection conn, Order order)throws Exception;

	void saveOrderItem(Connection conn, OrderItem item)throws Exception;

	int getTotalRecords(User user)throws Exception;

	List findMyOrdersWithPage(User user, int startIndex, int pageSize)throws Exception;

	Order findOrderByOid(String oid)throws Exception;

	void updateOrder(Order order)throws Exception;

}
