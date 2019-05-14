package com.pg.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pg.backend.entity.Product;
import com.pg.backend.util.HibernateUtils;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	/*
	 * SINGLE
	 */
	@Override
	public Product get(int productId) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
			Product prod = ses.get(Product.class, productId);
			tx.commit();
			return prod;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	/*
	 * LIST
	 */

	@Override
	public List<Product> list() {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
		List<Product> listProd = ses.createQuery("FROM Product", Product.class).getResultList();
		tx.commit();
		return listProd;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	/*
	 * INSERT
	 */
	@Override
	public boolean add(Product product) {
		Session ses = HibernateUtils.getSession();
		int idVal = 0;
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			// save obj
			idVal = (int) ses.save(product);
			System.out.println("Generated id value::" + idVal);
			flag = true;

		} // try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Objects are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			// HibernateUtils.closeSession(ses);
		}
		return flag;
	}

	/*
	 * UPDATE
	 */
	@Override
	public boolean update(Product product) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
			ses.update(product);
			tx.commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		return false;
	}

	/*
	 * DELETE
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		List<Product> activeProd = ses.createQuery(selectActiveProducts, Product.class).setParameter("active", true).getResultList();
		tx.commit();
		return activeProd ;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
		}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		List<Product> prod = ses.createQuery(selectActiveProductsByCategory, Product.class).setParameter("active", true)
				.setParameter("categoryId", categoryId).getResultList();
		tx.commit();
		return prod;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		try {
		List<Product> prod = ses.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		tx.commit();
		return prod;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
		Session ses = HibernateUtils.getSession();
		String query = "FROM Product WHERE active = true ORDER BY " + param + " DESC";
		Transaction tx = ses.beginTransaction();
		try {
		List<Product> prod = ses.createQuery(query, Product.class).setFirstResult(0).setMaxResults(count).getResultList();
		tx.commit();
		return prod;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;

	}

}
