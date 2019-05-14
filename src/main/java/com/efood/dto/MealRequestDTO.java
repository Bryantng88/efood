package com.efood.dto;

import com.efood.model.Meal;

public class MealRequestDTO {
	private String name;
	private String title;
	private String kcal;
	private String mealType;
	private String mealPackage;
	private int mealSale;
	private int mealCount;
	private String description;
	private String mealRecipe;
	
	public Meal toMeal() {
		Meal meal = new Meal();
		meal.setName(name);
		meal.setRecipe(mealRecipe);
		meal.setVolume(mealCount);
		meal.setDescription(description);
		meal.setCost(mealSale);
		return meal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getMealPackage() {
		return mealPackage;
	}
	public void setMealPackage(String mealPackage) {
		this.mealPackage = mealPackage;
	}
	public int getMealSale() {
		return mealSale;
	}
	public void setMealSale(int mealSale) {
		this.mealSale = mealSale;
	}
	public int getMealCount() {
		return mealCount;
	}
	public void setMealCount(int mealCount) {
		this.mealCount = mealCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
