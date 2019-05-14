package com.efood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efood.model.Order;
import com.efood.model.OrderDetail;

public interface OrderRepository {
	List<Order> findAllOrder();
	void insertOrder(Order order);
}
