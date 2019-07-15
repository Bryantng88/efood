package com.efood.dto;

import java.util.ArrayList;
import java.util.List;

import com.efood.common.MessageConst;
import com.efood.model.Meal;
import com.efood.model.MealType;

public class MealDTO {
	private int id;
	private String name;
	private int sale;
	private int volume;
	private int kcal;
	private String description;
	private String filePath;
	private List<String> mealTypes = new ArrayList<String>();
	
	public void copyFrom(Meal meal) {
		this.id = meal.getId().intValue();
		this.name = meal.getName();
		this.sale = meal.getSale();
		this.volume = meal.getVolume();
		this.description = meal.getDescription();
		this.kcal = meal.getKcal();
		this.setFilePath(String.format(MessageConst.DOMAIN, meal.getFilePath()));
		
		for (MealType item : meal.getMealTypes()) {
			 this.mealTypes.add(item.toString());
		}		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getMealTypes() {
		return mealTypes;
	}

	public void setMealTypes(List<String> mealTypes) {
		this.mealTypes = mealTypes;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}







}
