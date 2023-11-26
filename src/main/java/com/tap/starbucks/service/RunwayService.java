package com.tap.starbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.dao.RunwayDAO;
import com.tap.starbucks.entity.RunwayEntity;

@Component
public class RunwayService {

	private RunwayDAO runwayDAO;

	@Autowired
	public RunwayService(RunwayDAO runwayDAO) {
		super();
		this.runwayDAO = runwayDAO;
	}

	public RunwayService() {
		System.out.println("RunwayService Created");
	}

	public boolean validateRunwayObject(int length, int width, String surfaceType, String direction) {
		if(length>0) {
			System.out.println("length is valid");
		}else {
			System.out.println("length is invalid");
			return false;
		}
		if(width>0) {
			System.out.println("width is valid");
		}else {
			System.out.println("width is invalid");
			return false;
		}
		if(surfaceType !=null && !surfaceType.isEmpty()) {
			System.out.println("surfaceType is valid");
		}else {
			System.out.println("surfaceType is in valid");
			return false;
		}
		if(direction !=null && !direction.isEmpty()) {
			System.out.println("direction is valid");
			RunwayEntity entity = new RunwayEntity(length,width,surfaceType,direction);
			boolean result = runwayDAO.saveRunwayEntity(entity);
			return result;
		}else {
			System.out.println("direction is in valid");
			return false;
		}
	}
	
	public boolean validateRunwayID(int runwayID) {
		System.out.println("invoked validateRunwayID()");
		return runwayID>0?true:false;
		
	}
	
	public RunwayEntity getRunwayEntityByID(int runwayID) {
		return runwayDAO.getRunwayEntityByID(runwayID);
	}
	
	public boolean validateLength(int length) {
		System.out.println("invoked validateLength()");
		return length>0?true:false;
	}
	
	public boolean validateWidth(int Width) {
		System.out.println("invoked validateWidth()");
		return Width>0?true:false;
	}
	
	public boolean validateSurfaceType(String surfaceType) {
		System.out.println("invoked validateSurfaceType()");
		return surfaceType !=null && !surfaceType.isEmpty()?true:false;
	}
	
	public boolean validateDirection(String direction) {
		System.out.println("invoked validateDirection()");
		return direction !=null && !direction.isEmpty()?true:false;
	}
	
	public int updateRunwayByID(int runwayID, int length, int width, String surfaceType, String direction) {
		return runwayDAO.updateRunwayByID(runwayID, length, width, surfaceType, direction);
	}
	
	public int deleteByID(int runwayID) {
		return runwayDAO.deleteByID(runwayID);
	}
	
	public List<RunwayEntity> getAll(){
		return runwayDAO.getAll();
	}
}
