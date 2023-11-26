package com.tap.starbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.dao.AirportDAO;
import com.tap.starbucks.entity.AirportEntity;

@Component
public class AirportService {
	
	
	private AirportDAO airportDAO;
	
	@Autowired
	public AirportService(AirportDAO airportDAO) {
		
		this.airportDAO = airportDAO;
	}

	public AirportService() {
		System.out.println("AirportService Created");
	}

	public boolean validateAiportObject(String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
		
		if(airportName !=null && !airportName.isEmpty()) {
			System.out.println("airportName is valid");
		}else {
			System.out.println("airportName is in valid");
			return false;
		}
		if(airportLocation !=null && !airportLocation.isEmpty()) {
			System.out.println("airportLocation is valid");
		}else {
			System.out.println("airportLocation is invalid");
			return false;
		}
		if(noOfPlanes>0) {
			System.out.println("noOfPlanes is valid");
		}else {
			System.out.println("noOfPlanes is invalid");
			return false;
		}
		if(noOfRunways>0) {
			System.out.println("noOfRunways is valid");
			AirportEntity entity = new AirportEntity(airportName,airportLocation,noOfPlanes,noOfRunways);
			boolean result = airportDAO.saveAirportEntity(entity);
			return result;
		}else {
			System.out.println("noOfRunways is invalid");
			return false;
		}
		
		

	}
	public boolean validateAirportID(int airportID) {
		
		System.out.println("Invoked validateAirportID()");
		return airportID>0?true:false;
		
	}
	public AirportEntity getAirportEntityByID(int airportID) {
		return airportDAO.getAirportEntityByID(airportID);
		
	}
	public boolean validateAirportName(String airportName) {
		
		System.out.println("Invoked validateairportName()");
		return airportName !=null && !airportName.isEmpty()?true:false;
		
	}
	
	public AirportEntity getAirportEntityByName(String airportName) {
		return airportDAO.getAirportEntityByName(airportName);
		
	}
	
	public boolean validateAirportLocation(String airportLocation) {
		System.out.println("Invoked validateAirportLocation()");
		return airportLocation !=null && !airportLocation.isEmpty()?true:false;
	}
	
	public boolean validateNoOfPlanes(int noOfPlanes) {
		
		System.out.println("Invoked validateNoOfPlanes()");
		return noOfPlanes>0?true:false;
		
	}
	
	public boolean validateNoOfRunways(int noOfRunways) {
		
		System.out.println("Invoked validateNoOfRunways()");
		return noOfRunways>0?true:false;
		
	}
	
	public int deleteByID(int airportID) {
		return airportDAO.deleteByID(airportID);
	}

	public int deleteByName(String airportName) {
		
		return airportDAO.deleteByName(airportName);
	}

	public int updateByID(int airportID, String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
		
		return airportDAO.updateByID(airportID,airportName,airportLocation,noOfPlanes,noOfRunways);
		
	}

	public int updateByName(String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
		
		return airportDAO.updateByName(airportName,airportLocation,noOfPlanes,noOfRunways);
		
	}

	public List<AirportEntity> getAll() {
		return airportDAO.getAll();
		
		
	}
}
