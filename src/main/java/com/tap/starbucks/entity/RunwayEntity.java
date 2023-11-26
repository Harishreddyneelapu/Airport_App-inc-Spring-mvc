package com.tap.starbucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runway_table")
public class RunwayEntity {

	@Column(name = "RUNWAY_ID")
	@Id
	private int runwayID;

	@Column(name = "LENGTH")
	private int length;

	@Column(name = "WIDTH")
	private int width;

	@Column(name = "SURFACE_TYPE")
	private String surfaceType;

	@Column(name = "DIRECTION")
	private String direction;

	public RunwayEntity() {
		super();
	}

	public RunwayEntity(int runwayID, int length, int width, String surfaceType, String direction) {
		super();
		this.runwayID = runwayID;
		this.length = length;
		this.width = width;
		this.surfaceType = surfaceType;
		this.direction = direction;
	}

	public RunwayEntity(int length, int width, String surfaceType, String direction) {
		super();
		this.length = length;
		this.width = width;
		this.surfaceType = surfaceType;
		this.direction = direction;
	}

	public int getRunwayID() {
		return runwayID;
	}

	public void setRunwayID(int runwayID) {
		this.runwayID = runwayID;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getSurfaceType() {
		return surfaceType;
	}

	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "RunwayEntity [runwayID=" + runwayID + ", length=" + length + ", width=" + width + ", surfaceType="
				+ surfaceType + ", direction=" + direction + "]";
	}
}
