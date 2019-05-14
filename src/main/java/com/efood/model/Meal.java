package com.efood.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "sale")
	private int sale;
	
	@Column(name = "volume")
	private int volume;
	
	@Column(name = "recipe")
	private String recipe;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id")
	private DBFile dbFile;
	
	@Column(name = "description")
	private String description;
	

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", cost=" + cost + ", sale=" + sale + ", volume=" + volume
				+ ", recipe=" + recipe + ", dbFile=" + dbFile + ", description=" + description + "]";
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


	public DBFile getDbFile() {
		return dbFile;
	}

	public void setDbFile(DBFile dbFile) {
		this.dbFile = dbFile;
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


	
	
	
//	@ManyToOne
//	@JoinColumn(name = "meal_id")
//	private OrderDetail orderDetail;
}
