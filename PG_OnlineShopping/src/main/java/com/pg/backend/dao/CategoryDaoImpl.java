package com.pg.backend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pg.backend.entity.Category;
import com.pg.backend.util.HibernateUtils;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	

	/*
	 * This method is used to return the list of all categories
	 */
	@Override
	public List<Category> listCategory() {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		Query query=null;
		 try {
			 final String selectActiveCategory = "FROM Category WHERE active = :active"; 
				query = ses.createQuery(selectActiveCategory,Category.class);
				query.setParameter("active", true);
				List<Category> category = query.getResultList();
				 tx.commit();
				 return category;
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			 tx.rollback();
		}
		return null;
	}

	/*
	 * This method is used to return a single category based on the category id
	 */
	@Override
	public Category get(int id) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		Category category =null;
		 try {
		category = ses.get(Category.class, id);
		 tx.commit();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			 tx.rollback();
		}
		return category;
	}

	/*
	 * This method is used to add new category to database
	 */
	@Override
	public boolean addCategory(Category category) {
		Session ses = HibernateUtils.getSession();
		int idVal = 0;
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			// save obj
			idVal = (int) ses.save(category);
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
	 * This method is used to update the category
	 */
	@Override
	public boolean updateCategory(Category category) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		boolean isUpdated = false;
		try {
			ses.update(category);
			isUpdated = true;
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isUpdated) {
				tx.commit();
			} else {
				tx.rollback();
			}
		}
		return isUpdated;
	}

	/*
	 * This method is used to soft delete the category
	 */
	@Override
	public boolean deleteCategory(Category category) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		category.setActive(false);
		boolean isUpdated = false;
		try {
			ses.update(category);
			isUpdated = true;
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isUpdated) {
				tx.commit();
			} else {
				tx.rollback();
			}
		}
		return isUpdated;
	}

}
