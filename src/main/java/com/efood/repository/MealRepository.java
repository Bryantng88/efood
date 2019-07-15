package com.efood.repository;

import java.util.List;

import com.efood.model.EMealType;
import com.efood.model.Meal;
import com.efood.model.MealType;

public interface MealRepository {
	Meal save(Meal meal);
	List<Meal> findAll();
	Meal findByMealName(String mealName);
	List<MealType> findMealType(List<EMealType> eMealType);
}
