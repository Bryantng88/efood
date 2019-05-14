package com.efood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.efood.model.Order;
import com.efood.model.OrderDetail;
import com.efood.repository.OrderDetailRepository;
import com.efood.repository.OrderRepository;
import com.efood.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;
	
	@Override
	public List<OrderDetail> findOneOrderDetail(int id) {
		return orderDetailRepo.findOneOrderDetail(id);
	}

	@Override
	public List<Order> findAllOrder() throws AccessDeniedException{
		// TODO Auto-generated method stub
		
		return orderRepo.findAllOrder();
	}
	
	@Override
	public void updateOrderDetail(Long id) {
		orderDetailRepo.updateOrderDetail(id);
		
	}

	@Override
	public void insertOrder(Order order) {
		orderRepo.insertOrder(order);	
	}

	@Override
	public void insertOrderDetail(List<OrderDetail> orderDetails) {
		orderDetailRepo.insertOrderDetail(orderDetails);
		
	}

	@Override
	public List<OrderDetail> findAllOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetailRepo.findAllOrderDetail();
	}



}
