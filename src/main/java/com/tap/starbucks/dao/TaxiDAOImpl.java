package com.tap.starbucks.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.entity.TaxiEntity;

@Component
public class TaxiDAOImpl implements TaxiDAO{
	
	SessionFactory sessionFactory;
	
	@Autowired
	public TaxiDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveTaxiEntity(TaxiEntity entity) {
		System.out.println("invoked saveTaxiEntity()");
		Session session =null;
		boolean isDataSaved=false;
		
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Serializable save = session.save(entity);	
			System.out.println("save ="+save);
			session.getTransaction().commit();
			System.out.println("TaxiEntity has been saved");

			isDataSaved = true;
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}

	public List<TaxiEntity> getAll() {
		System.out.println("invoked getAll()");
		Session session =null;
		List<TaxiEntity> taxiEntities = null;
		try {
			session = sessionFactory.openSession();
			taxiEntities = session.createQuery("From TaxiEntity", TaxiEntity.class).list();
		}finally {
			if (session != null) {
	            session.close();
	            System.out.println("Session is closed");
	        }
		}
		return taxiEntities;
	}

	public int updateTaxiByID(int taxiID, String model, String driverName, String currLocation, String availability) {
		System.out.println("invoked updateTaxiByID()");
		Session session =null;
		try {
			session=sessionFactory.openSession();
			session.beginTransaction();
			
			TaxiEntity entity = session.get(TaxiEntity.class, taxiID);
			if(Objects.nonNull(entity)) {
				entity.setModel(model);
				entity.setDriverName(driverName);
				entity.setCurrLocation(currLocation);
				entity.setAvailability(availability);
				
				session.update(entity);
				session.getTransaction().commit();
				
				System.out.println("TaxiEntity with ID "+ taxiID+"has been updated.");
				return 1;
			}
			
			
		}finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		
		return 0;
	}

	public TaxiEntity getTaxiEntityByID(int id) {
		System.out.println("invoked getTaxiEntityByID()");
		Session session=null;
		TaxiEntity entity=null;
		try {
			session=this.sessionFactory.openSession();
			entity = session.get(TaxiEntity.class, id);
			if(entity!=null) {
				return entity;
			}
		}finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}

	public int deleteByID(int taxiID) {
		System.out.println("invoked deleteByID()");
		Session session=null;
		TaxiEntity entity=null;
		try {
			session=this.sessionFactory.openSession();
			session.beginTransaction();
			entity = session.get(TaxiEntity.class,taxiID);
			if(Objects.nonNull(entity)) {
				session.delete(entity);
				session.getTransaction().commit();
				
				System.out.println("TaxiEntity with ID "+ taxiID +"has been deleted.");
				return 1;
			}
		}finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return 0;
	}

}
