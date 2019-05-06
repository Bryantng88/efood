package com.bfwg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfwg.model.Order;
import com.bfwg.model.OrderDetail;

public interface OrderRepository {
	List<Order> findAllOrder();
	void insertOrder(Order order);
}
