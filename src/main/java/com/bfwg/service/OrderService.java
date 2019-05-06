package com.bfwg.service;

import java.util.List;

import com.bfwg.model.Order;
import com.bfwg.model.OrderDetail;

public interface OrderService {
	List<Order> findAllOrder();
	List<OrderDetail> findAllOrderDetail();
	List<OrderDetail> findOneOrderDetail(int id);
	void insertOrder(Order order);
	void insertOrderDetail (List<OrderDetail> orderDetails);
	void updateOrderDetail(Long id);
}
