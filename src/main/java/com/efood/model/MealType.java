package com.efood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "MEAL_TYPE")
public class MealType {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	EMealType name;

	@Override
	public String toString() {
		StringBuffer strMealType = new StringBuffer();
		strMealType.append(this.name);

		return strMealType.toString();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EMealType getMealType() {
		return name;
	}

	public void setMealType(EMealType name) {
		this.name = name;
	}
	
	
}
