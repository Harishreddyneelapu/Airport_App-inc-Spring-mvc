package com.tap.starbucks.dao;

import java.util.List;

import com.tap.starbucks.entity.TaxiEntity;

public interface TaxiDAO {
	boolean saveTaxiEntity(TaxiEntity entity);
	List<TaxiEntity> getAll();
	int updateTaxiByID(int taxiID, String model, String driverName, String currLocation, String availability);
	TaxiEntity getTaxiEntityByID(int id);
	int deleteByID(int taxiID);
}
