package com.tap.starbucks.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.starbucks.entity.AirportEntity;

@Component
public class AirportDAOImpl implements AirportDAO{
	
	
	SessionFactory sessionFactory;
	
	@Autowired
	public AirportDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("sessionfactory injected my ioc container");
	}
	
	public boolean saveAirportEntity(AirportEntity entity) {
		System.out.println("invoked saveAirportEntity");
		Session session = null;
		boolean isDataSaved = false;
		try {
			
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Serializable save = session.save(entity);	
			System.out.println("save ="+save);
			session.getTransaction().commit();
			System.out.println("AirportEntity has been saved");

			isDataSaved = true;
			
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return isDataSaved;
	}

	public AirportEntity getAirportEntityByID(int id) {

		System.out.println("invoked getAirportEntityByID");
		Session session = null;
		AirportEntity entity =null;
	
		try {
			
			session = this.sessionFactory.openSession();
			entity = session.get(AirportEntity.class, id);
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

	public AirportEntity getAirportEntityByName(String airportName) {
	
		System.out.println("invoked getAirportEntityByName");
		Session session = null;
		AirportEntity entity =null;
		String hql = "from AirportEntity where airportName =:airportName";
	
		try {
			
			session = this.sessionFactory.openSession();
			entity = session.createQuery(hql,AirportEntity.class).setParameter("airportName", airportName).uniqueResult();
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

	public int deleteByID(int airportID) {
		
		System.out.println("invoked deleteByID()");
		Session session = null;
		AirportEntity entity =null;
		
		try {
			
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			entity = session.get(AirportEntity.class, airportID);
			if(Objects.nonNull(entity)) {
				session.delete(entity);
				session.getTransaction().commit();
				
				System.out.println("AirportEntity with ID " + airportID + " has been deleted.");
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

	public int deleteByName(String airportName) {
		// TODO Auto-generated method stub
		System.out.println("invoked deleteByName()");
		Session session = null;
		int rowsAffected=0;
		
		String hql="delete from AirportEntity where airportName =:airportName";
		try {
			
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			rowsAffected = session.createQuery(hql)
	                .setParameter("airportName", airportName)
	                .executeUpdate();
			session.getTransaction().commit();
			
			
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			
		}
		
		return rowsAffected;
	}

	

	public int updateByID(int airportID, String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
	    System.out.println("invoked updateByID()");
	    Session session = null;

	    try {
	        session = this.sessionFactory.openSession();
	        session.beginTransaction();

	        AirportEntity entity = session.get(AirportEntity.class, airportID);
	        if (Objects.nonNull(entity)) {
	            entity.setAirportName(airportName);
	            entity.setAirportLocation(airportLocation);
	            entity.setNoOfPlanes(noOfPlanes);
	            entity.setNoOfRunways(noOfRunways);

	            session.update(entity);
	            session.getTransaction().commit();

	            System.out.println("AirportEntity with ID " + airportID + " has been updated.");
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

	public int updateByName(String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
		// TODO Auto-generated method stub
		System.out.println("invoked updateByName()");
		Session session = null;
		int rowsAffected = 0;
		 try {
		        session = this.sessionFactory.openSession();
		        session.beginTransaction();

		        String hql = "update AirportEntity set airportLocation = :airportLocation, " +
		                     "noOfPlanes = :noOfPlanes, noOfRunways = :noOfRunways " +
		                     "where airportName = :airportName";

		        rowsAffected = session.createQuery(hql)
		                .setParameter("airportLocation", airportLocation)
		                .setParameter("noOfPlanes", noOfPlanes)
		                .setParameter("noOfRunways", noOfRunways)
		                .setParameter("airportName", airportName)
		                .executeUpdate();

		        session.getTransaction().commit();

		        System.out.println("Updated " + rowsAffected + " rows for airportName: " + airportName);
		       
		    }finally {
			if (session != null) {
	            session.close();
	            System.out.println("session is closed");
	        }
		}
		
		return rowsAffected;
	}

	public List<AirportEntity> getAll() {
		System.out.println("invoked getAll()");
	    Session session = null;
	    List<AirportEntity> airportEntities = null;

	    try {
	        session = sessionFactory.openSession();
	        airportEntities = session.createQuery("FROM AirportEntity", AirportEntity.class).list();
	    }  finally {
	        if (session != null) {
	            session.close();
	            System.out.println("Session is closed");
	        }
	    }

	    return airportEntities;
	}


}
