package com.efood.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efood.model.DBFile;
import com.efood.model.Meal;
import com.efood.repository.DBFileRepository;

@Repository
public class DBFileRepositoryImpl implements DBFileRepository {
	@Autowired
	EntityManager em;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Transactional
	@Override
	public DBFile save(DBFile dbFile) {
		em.persist(dbFile);
		return dbFile;
	}

	@Override
	public void addMeal(DBFile file, Meal meal) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		meal.setDbFile(file);
		em.persist(meal);
		em.getTransaction().commit();
	}

}
