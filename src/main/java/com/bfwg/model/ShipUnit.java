package com.bfwg.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "SHIP_UNIT")
public class ShipUnit {
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", dateCreated=" + dateCreated + ", dateFinished=" + dateFinished + ", status="
				+ status + ", delivery=" + shipment + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Shipment getDelivery() {
		return shipment;
	}

	public void setDelivery(Shipment shipment) {
		this.shipment = shipment;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "date_finished")
	private Date dateFinished;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@ManyToOne
	private Shipment shipment;
	
	@OneToMany(mappedBy = "shipUnit")
	private List<OrderDetail> orderDetail;
}
