package com.efood.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efood.model.MealType;
import com.efood.model.EMealType;
import com.efood.model.EUserRoleName;
import com.efood.model.Meal;
import com.efood.model.MealType;
import com.efood.model.User;
import com.efood.repository.MealRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MealRepositoryImpl implements MealRepository {
	@Autowired
	EntityManager em;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Transactional
	@Override
	public Meal save(Meal meal) {
		em.persist(meal);
		return meal;
	}

	@Override
	public List<Meal> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Meal> cq = cb.createQuery(Meal.class);
		Root<Meal> meals = cq.from(Meal.class);
		cq.select(meals);
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Meal findByMealName(String mealName) {
		Meal meal = new Meal();
		Query query = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Meal> cq = cb.createQuery(Meal.class);
			Root<Meal> root = cq.from(Meal.class);
			cq.select(root).where(cb.equal(root.get("name"), mealName));
			query = em.createQuery(cq);
			meal = (Meal) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return meal;
	}
	@Override
	public List<MealType> findMealType(List<EMealType> eMealTypes) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealType> cq = cb.createQuery(MealType.class);
		Root<MealType> auth = cq.from(MealType.class);
		cq.select(auth).where(auth.get("name").in(eMealTypes));
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

}
