package com.tap.starbucks.dao;

import java.util.List;

import com.tap.starbucks.entity.RunwayEntity;

public interface RunwayDAO {

	boolean saveRunwayEntity(RunwayEntity entity);
	List<RunwayEntity> getAll();
	int updateRunwayByID(int runwayID, int length, int width, String surfaceType, String direction);
	RunwayEntity getRunwayEntityByID(int runwayID);
	int deleteByID(int runwayID);

}
