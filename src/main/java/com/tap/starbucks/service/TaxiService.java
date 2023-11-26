package com.tap.starbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.dao.TaxiDAO;
import com.tap.starbucks.entity.TaxiEntity;

@Component
public class TaxiService {
	
	private TaxiDAO taxiDAO;
	
	@Autowired
	public TaxiService(TaxiDAO taxiDAO) {
		super();
		this.taxiDAO = taxiDAO;
	}
	
	public boolean validateTaxiObject(String model, String driverName, String currLocation, String availability) {
		if(model !=null && !model.isEmpty()) {
			System.out.println("model is valid");
		}else {
			System.out.println("model is in valid");
			return false;
		}
		if(driverName !=null && !driverName.isEmpty()) {
			System.out.println("driverName is valid");
		}else {
			System.out.println("driverName is in valid");
			return false;
		}
		if(currLocation !=null && !currLocation.isEmpty()) {
			System.out.println("currLocation is valid");
		}else {
			System.out.println("currLocation is in valid");
			return false;
		}
		if(availability !=null && !availability.isEmpty()) {
			System.out.println("availability is valid");
			TaxiEntity entity = new TaxiEntity(model,driverName,currLocation,availability);
			boolean result = taxiDAO.saveTaxiEntity(entity);
			return result;
		}else {
			System.out.println("availability is in valid");
			return false;
		}
		
		
	}
	
	public boolean validateTaxiID(int taxiID) {
		System.out.println("invoked validateTaxiID()");
		return taxiID>0?true:false;
	}
	
	public boolean validateTaxiDriverName(String driverName) {
		return driverName !=null && !driverName.isEmpty()?true:false;
	}
	
	public boolean validateTaxiModel(String model) {
		return model !=null && !model.isEmpty()?true:false;
	}
	
	public boolean validateTaxiCurrLocation(String currLocation) {
		return currLocation !=null && !currLocation.isEmpty()?true:false;
	}
	
	public boolean validateTaxiAvailability(String availability) {
		return availability !=null && !availability.isEmpty()?true:false;
	}
	
	public int updateTaxiByID(int taxiID, String model, String driverName, String currLocation,String availability) {
		return taxiDAO.updateTaxiByID(taxiID,model,driverName,currLocation,availability);
		
	}
	public List<TaxiEntity> getAll(){
		return taxiDAO.getAll();
	}

	public TaxiEntity getTaxiEntityByID(int id) {
		return taxiDAO.getTaxiEntityByID(id);

		
	}

	public int deleteByID(int taxiID) {

		return taxiDAO.deleteByID(taxiID);
	}
}
