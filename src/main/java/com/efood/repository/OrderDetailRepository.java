package com.efood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efood.model.OrderDetail;

public interface OrderDetailRepository{
	List<OrderDetail> findAllOrderDetail();
	
	List<OrderDetail> findOneOrderDetail(int id);
	void updateOrderDetail(Long id);
	void insertOrderDetail(List<OrderDetail> orderDetails);
}
