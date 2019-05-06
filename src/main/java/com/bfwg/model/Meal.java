package com.bfwg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	

	
	@Override
	public String toString() {
		return "MealDetail [id=" + id + ", name=" + name + ", cost=" + cost + ", volume=" + volume + ", recipe="
				+ recipe + ", description=" + description + "]";
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

	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "volume")
	private int volume;
	
	@Column(name = "recipe")
	private String recipe;
	
	@Column(name = "description")
	private String description;
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "meal_id")
//	private OrderDetail orderDetail;
}