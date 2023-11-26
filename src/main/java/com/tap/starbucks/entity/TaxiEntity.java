package com.tap.starbucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxi_table")
public class TaxiEntity {
	
	@Column(name="TAXI_ID")
	@Id
	private int taxiID;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	@Column(name="CURR_LOCATION")
	private String currLocation;
	
	@Column(name="AVAILABILITY")
	private String availability;

	public TaxiEntity() {
		super();
	}

	public TaxiEntity(int taxiID, String model, String driverName, String currLocation, String availability) {
		super();
		this.taxiID = taxiID;
		this.model = model;
		this.driverName = driverName;
		this.currLocation = currLocation;
		this.availability = availability;
	}

	public TaxiEntity(String model, String driverName, String currLocation, String availability) {
		super();
		this.model = model;
		this.driverName = driverName;
		this.currLocation = currLocation;
		this.availability = availability;
	}

	public int getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(String currLocation) {
		this.currLocation = currLocation;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "TaxiEntity [taxiID=" + taxiID + ", model=" + model + ", driverName=" + driverName + ", currLocation="
				+ currLocation + ", availability=" + availability + "]";
	}
	
	
	

}
