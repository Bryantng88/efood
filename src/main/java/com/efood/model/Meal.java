package com.efood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "MEAL")
public class Meal {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "cost")
	private int cost;

	@Column(name = "kcal")
	private int kcal;

	@Column(name = "sale")
	private int sale;

	@Column(name = "volume")
	private int volume;

	@Column(name = "recipe")
	private String recipe;

	@Column(name = "file")
	private String filePath;

	@Column(name = "description")
	private String description;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "meal_mealType", joinColumns = @JoinColumn(name = "meal_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "mealType_id", referencedColumnName = "id"))
	private List<MealType> mealTypes = new ArrayList<MealType>();

	@Override
	public String toString() {
		StringBuffer strMeal = new StringBuffer();
		strMeal.append("Meal info:\nMeal Name: ").append(this.name).append("\nDescription: ").append(this.description)
				.append("\nSale: ").append(this.sale).append("\nCost: ").append(this.cost).append("\nVolume: ")
				.append(this.volume).append("\nRecipe: ").append(this.recipe).append("\nFile: ").append(this.filePath)
				.append("\nMeal Types:\n").append(this.mealTypes);

		return strMeal.toString();
	}

	public List<MealType> getMealTypes() {
		return mealTypes;
	}

	public void setMealTypes(List<MealType> mealTypes) {
		this.mealTypes = mealTypes;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
}
