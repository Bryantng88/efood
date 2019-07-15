package com.efood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efood.common.MessageConst;
import com.efood.dto.ResponseDTO;
import com.efood.model.EMealType;
import com.efood.model.Meal;
import com.efood.model.MealType;
import com.efood.repository.MealRepository;
import com.efood.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	MealRepository mealRepository;

	@Override
	public ResponseDTO<Meal> save(Meal meal) {		
		ResponseDTO<Meal> response = new ResponseDTO<Meal>();
		Boolean isValid = validate(meal, response);	
		if (isValid) {
			List<EMealType> list = new ArrayList<EMealType>();
			for (MealType item : meal.getMealTypes()) {
				list.add(item.getMealType());
			}
			List<MealType> mealTypes = mealRepository.findMealType(list);
			meal.setMealTypes(mealTypes);
			//final action
			Meal mealResult = mealRepository.save(meal);
			response.setData(mealResult);
			System.out.println(meal);
		}
		return response;

	}
	@Override
	public List<Meal> findAll() {
		return mealRepository.findAll();
	}
	
	private Boolean validate(Meal meal, ResponseDTO<Meal> response) {
		Meal mealResult = mealRepository.findByMealName(meal.getName());
		if (mealResult.getId() != null) {
			response.setErrorMessage(MessageConst.ERROR_MEAL_EXISTS);
			return false;
		}		
		return true;
	}

}
