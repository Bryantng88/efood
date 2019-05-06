package com.bfwg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.bfwg.model.Order;
import com.bfwg.model.OrderDetail;
import com.bfwg.repository.OrderDetailRepository;
import com.bfwg.repository.OrderRepository;
import com.bfwg.service.OrderService;

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
