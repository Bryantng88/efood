package com.efood.service;

import java.util.List;

import com.efood.model.Order;
import com.efood.model.OrderDetail;

public interface OrderService {
	List<Order> findAllOrder();
	List<OrderDetail> findAllOrderDetail();
	List<OrderDetail> findOneOrderDetail(int id);
	void insertOrder(Order order);
	void insertOrderDetail (List<OrderDetail> orderDetails);
	void updateOrderDetail(Long id);
}
