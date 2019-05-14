package com.efood.service;

import com.efood.dto.ResponseDTO;
import com.efood.model.Meal;

public interface MealService {
	ResponseDTO<Meal> save(Meal meal);
}
