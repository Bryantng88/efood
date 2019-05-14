package com.efood.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efood.model.Authority;
import com.efood.model.EUserRoleName;
import com.efood.model.User;
import com.efood.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	EntityManager em;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public User findByUsername(String username) {
		User user = new User();
		Query query = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("username"), username));
			query = em.createQuery(cq);
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> users = cq.from(User.class);
		cq.select(users);
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

	@Transactional
	@Override
	public User save(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public Authority findAuthority(EUserRoleName eUserRoleName) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Authority> cq = cb.createQuery(Authority.class);
		Root<Authority> auth = cq.from(Authority.class);
		cq.select(auth).where(cb.equal(auth.get("name"), eUserRoleName));
		Query query = em.createQuery(cq);
		return (Authority) query.getSingleResult();
	}
	@Override
	public List<Authority> findAuthorities(List<EUserRoleName> eUserRoleNames) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Authority> cq = cb.createQuery(Authority.class);
		Root<Authority> auth = cq.from(Authority.class);
		cq.select(auth).where(auth.get("name").in(eUserRoleNames));
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public User findByUserEmail(String email) {
		User user = new User();
		Query query = null;

		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("email"), email));
			query = em.createQuery(cq);
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return user;
	}
}
