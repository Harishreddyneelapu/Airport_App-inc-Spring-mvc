package com.tap.starbucks.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.entity.RunwayEntity;

@Component
public class RunwayDAOImpl implements RunwayDAO {

	SessionFactory sessionFactory;

	@Autowired
	public RunwayDAOImpl(SessionFactory sessionFactory) {
		System.out.println("sessionfactory injected my ioc container1");
		this.sessionFactory = sessionFactory;
	}

	public boolean saveRunwayEntity(RunwayEntity entity) {
		System.out.println("invoked saveRunwayEntity()");
		Session session = null;
		boolean isDataSaved = false;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Serializable save = session.save(entity);
			System.out.println("save =" + save);
			session.getTransaction().commit();
			System.out.println("RunwayEntity has been saved");

			isDataSaved = true;
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}

	public List<RunwayEntity> getAll() {
		System.out.println("invoked getAll()");
		Session session = null;
		List<RunwayEntity> runwayEntities = null;
		try {
			session = sessionFactory.openSession();
			runwayEntities = session.createQuery("FROM RunwayEntity", RunwayEntity.class).list();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			}
		}
		return runwayEntities;
	}

	public int updateRunwayByID(int runwayID, int length, int width, String surfaceType, String direction) {
		System.out.println("invoked updateByID()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RunwayEntity entity = session.get(RunwayEntity.class, runwayID);
			if(Objects.nonNull(entity)) {
				entity.setLength(length);
				entity.setWidth(width);
				entity.setSurfaceType(surfaceType);
				entity.setDirection(direction);
				
				session.update(entity);
				session.getTransaction().commit();
				
				System.out.println("RunwayEntity with ID "+ runwayID+"has been updated.");
				return 1;
			}
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return 0;
	}

	public RunwayEntity getRunwayEntityByID(int id) {
		System.out.println("invoked getRunwayEntityByID()");
		Session session = null;
		RunwayEntity entity = null;
		try {
			session = this.sessionFactory.openSession();
			entity = session.get(RunwayEntity.class, id);
			if(entity!=null) {
				return entity;
			}
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}

	public int deleteByID(int runwayID) {
		System.out.println("invoked deleteByID()");
		Session session =null;
		RunwayEntity entity = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			entity = session.get(RunwayEntity.class, runwayID);
			if(Objects.nonNull(entity)) {
				session.delete(entity);
				session.getTransaction().commit();
				
				System.out.println("RunwayEntity with ID " + runwayID + " has been deleted.");
				return 1;
			}
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return 0;
	}

}
