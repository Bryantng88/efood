package com.efood.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efood.model.MealType;
import com.efood.model.Order;
import com.efood.model.OrderDetail;
import com.efood.repository.OrderDetailRepository;

@Primary
@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

	private static final MealType SIDEDISH = null;
	@Autowired
	EntityManager em;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<OrderDetail> findOneOrderDetail(int id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderDetail> cq = cb.createQuery(OrderDetail.class);
		Root<OrderDetail> root = cq.from(OrderDetail.class);
		cq.select(root).where(cb.equal(root.get("id"), id));
		Query query = em.createQuery(cq);
		System.out.println(query.getResultList());
		return query.getResultList();

	}

	@Override
	public List<OrderDetail> findAllOrderDetail() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderDetail> cq = cb.createQuery(OrderDetail.class);
		Root<OrderDetail> root = cq.from(OrderDetail.class);
		cq.select(root);
		Query query = em.createQuery(cq);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Transactional
	public void insertOrderDetail(List<OrderDetail> orderDetails) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Order order = new Order();
		order.setOrderDetails(orderDetails);
		
		em.persist(order);
		em.getTransaction().commit();
		
	}

	@Transactional
	public void updateOrderDetail(Long id) {
		OrderDetail od = new OrderDetail();
		
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		od = em.find(OrderDetail.class, id);
//		od.setMealType(SIDEDISH);
		em.getTransaction().commit();
	}

}
