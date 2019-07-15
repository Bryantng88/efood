package com.efood.dto;

import java.util.ArrayList;
import java.util.List;

import com.efood.model.EMealPackage;
import com.efood.model.EMealType;
import com.efood.model.Meal;
import com.efood.model.MealType;

public class MealRequestDTO {
	private String name;
	private int kcal;
	private List<String> mealTypes = new ArrayList<String>();
//	private List<String> mealPackage = new ArrayList<String>();
	private int sale;
	private int volume;
	private String description;
	private String recipe;
	
	
	public Meal toMeal() {
		Meal meal = new Meal();
		meal.setName(name);
		meal.setRecipe(recipe);
		meal.setVolume(volume);
		meal.setDescription(description);
		meal.setKcal(kcal);
		meal.setSale(sale);
		
		for(String item: this.mealTypes) {
			MealType mealType = new MealType();
			mealType.setMealType(EMealType.valueOf(item));
			meal.getMealTypes().add(mealType);
		}
		
//		List<EMealPackage> listMealPackage = new ArrayList<EMealPackage>();
//		for(String mealP: this.mealPackage) {
//			listMealPackage.add(EMealPackage.valueOf(mealP));
//		}
//		meal.setMealPackages(listMealPackage);
		return meal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}


	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
