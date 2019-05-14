package com.efood.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ORDER_DETAIL",
		uniqueConstraints = 
		@UniqueConstraint(columnNames = {"day", "menu_type", "meal_type" })  
		
		)
public class OrderDetail {

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", weekDay=" + weekDay + ", weekType=" + weekType + ", mealType=" + mealType
				+ ", status=" + status + ", menuType=" + menuType + ", meal=" + meal + ", order=" + order
				+ ", shipUnit=" + shipUnit + "]";
	}

	@Id
	@Column(name = "order_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "order_id")
//	private String orderId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "day")
	private WeekDay weekDay;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;

	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public WeekType getWeekType() {
		return weekType;
	}

	public void setWeekType(WeekType weekType) {
		this.weekType = weekType;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public Meal getMealDetail() {
		return meal;
	}

	public void setMealDetail(Meal meal) {
		this.meal = meal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ShipUnit getShipment() {
		return shipUnit;
	}

	public void setShipment(ShipUnit shipUnit) {
		this.shipUnit = shipUnit;
	}
	
	@Column(name = "order_detail_sale_amount")
	private int salesAmount;

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public ShipUnit getShipUnit() {
		return shipUnit;
	}

	public void setShipUnit(ShipUnit shipUnit) {
		this.shipUnit = shipUnit;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "week_type")
	private WeekType weekType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "meal_type")
	private MealType mealType;


//	@Column(name = "order_unit_id")

	@Enumerated(EnumType.STRING)
	@Column(length = 12)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "menu_type")
	private MenuType menuType;
	
	@ManyToOne
	private Meal meal;

	@ManyToOne (fetch = FetchType.LAZY)
	private Order order;
	
	@ManyToOne
	private ShipUnit shipUnit;
//	

}
