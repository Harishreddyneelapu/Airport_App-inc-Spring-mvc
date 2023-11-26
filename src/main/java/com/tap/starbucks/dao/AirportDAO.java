package com.tap.starbucks.dao;

import java.util.List;

import com.tap.starbucks.entity.AirportEntity;

public interface AirportDAO {
	boolean saveAirportEntity(AirportEntity entity);

	AirportEntity getAirportEntityByID(int id);
	AirportEntity getAirportEntityByName(String AirportName);

	int deleteByID(int airportID);

	int deleteByName(String airportName);

	int updateByID(int airportID, String airportName, String airportLocation, int noOfPlanes, int noOfRunways);

	int updateByName(String airportName, String airportLocation, int noOfPlanes, int noOfRunways);

	List<AirportEntity> getAll();
	
	
}
