package service.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.ToaThuoc;
import service.ToaThuocService;
import util.Connect;

public class ToaThuocImpl implements ToaThuocService{
	private OgmSessionFactory sessionFactory;

	public ToaThuocImpl() {
	    sessionFactory = Connect.getInstance().getSessionFactory();
	}
	@Override
	public boolean createToaThuoc(ToaThuoc toaThuoc) {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      tr.begin();
	      session.save(toaThuoc);
	      tr.commit();
	      System.out.println("Create Success!");
	      return true;
	    } catch (Exception e) {
	    	System.out.println("No data available!");
	      e.printStackTrace();
	      tr.rollback();
	    }
	    return false;
	}

	@Override
	public List<ToaThuoc> findAll() {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      String queryString = "FROM ToaThuoc";
	      tr.begin();
	      List<ToaThuoc> toaThuocs = session.createQuery(queryString, ToaThuoc.class).getResultList();
	      toaThuocs.forEach(x -> System.out.println("findAllToaThuoc: " + x));
	      tr.commit();
	      return toaThuocs;
	    } catch (Exception e) {
	    	System.out.println("No data available!");
	      e.printStackTrace();
	      tr.rollback();
	    }
	    return null;
	}

	@Override
	public ToaThuoc findById(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      tr.begin();
	      ToaThuoc toaThuoc = session.find(ToaThuoc.class, id);
	      System.out.println("findById: " + id + " toaThuoc: " + toaThuoc);
	      tr.commit();
	      return toaThuoc;
	    } catch (Exception e) {
	    	System.out.println("No data available!");
	      e.printStackTrace();
	      tr.rollback();
	    }
	    return null;
	}

}
