package com.bfwg.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bfwg.model.Order;
import com.bfwg.repository.OrderRepository;

@Primary
@Qualifier
@Repository
public class OrderRepositoryImpl implements OrderRepository{
	@Autowired
	EntityManager em;
	

	public List<Order> findAllOrder() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		cq.select(root);
		Query query = em.createQuery(cq);
		return query.getResultList();
	}
	

	
	@Transactional	
	@Override
//	public void insertOrder(Order order) {
//		EntityManager em1 = entityManagerFactory.createEntityManager();
//		// TODO Auto-generated method stub
//		em1.getTransaction().begin();
//		String query = "INSERT INTO ORDER_BASE (remark, order_name, status, assignee, customer) VALUES (?,?,?,?,?);";
//		em1.createNativeQuery(query)
//			.setParameter(1, order.getRemark())
//			.setParameter(2, order.getOrderName())
//			.setParameter(3, order.getStatus())
//			.setParameter(4, order.getAssignee())
//			.setParameter(5, order.getCustomer())
//			.executeUpdate();
//		System.out.println("success");
//
//		em1.getTransaction().commit();
//		em1.close();
//	};
//	
	public void insertOrder(Order order) {
		this.em.persist(order);
	}
	
}
