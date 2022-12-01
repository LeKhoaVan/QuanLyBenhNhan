package service.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.ChiTietPhieuKham;
import service.ChiTietPhieuKhamService;
import util.Connect;

public class ChiTietPhieuKhamImpl  implements ChiTietPhieuKhamService{
	private OgmSessionFactory sessionFactory;

	public ChiTietPhieuKhamImpl() {
	    sessionFactory = Connect.getInstance().getSessionFactory();
	}
	
	@Override
	public boolean createChiTietPhieuKham(ChiTietPhieuKham chiTietPhieuKham) {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      tr.begin();
	      session.save(chiTietPhieuKham);
	      tr.commit();
	      System.out.println("Create Success!");
	      return true;
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("No data available!");
	      tr.rollback();
	    }
	    return false;
	}

	@Override
	public List<ChiTietPhieuKham> findAll() {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      String queryString = "FROM ChiTietPhieuKham";
	      tr.begin();
	      List<ChiTietPhieuKham> ctPhieuKhams = session.createQuery(queryString, ChiTietPhieuKham.class).getResultList();
	      ctPhieuKhams.forEach(x -> System.out.println("findAllChiTietPhieuKham: " + x));
	      tr.commit();
	      return ctPhieuKhams;
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("No data available!");
	      tr.rollback();
	    }
	    return null;
	}

	@Override
	public ChiTietPhieuKham findById(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
	    Transaction tr = session.getTransaction();
	    try {
	      tr.begin();
	      ChiTietPhieuKham chiTietPhieuKham = session.find(ChiTietPhieuKham.class, id);
	      System.out.println("findById: " + id + " - ChiTietPhieuKham: " + chiTietPhieuKham + " Benh: " 
	    		  + chiTietPhieuKham.getBenh());
	      tr.commit();
	      return chiTietPhieuKham;
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("No data available!");
	      tr.rollback();
	    }
	    return null;
	}
}
