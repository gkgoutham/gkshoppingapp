package com.gk.app.shopping.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gk.app.shopping.bean.UserType;
import com.gk.app.shopping.bean.Users;
import com.gk.app.shopping.dao.UserRepositoryI;

@Repository("userDAO")
public class UserRepositoryImpl implements UserRepositoryI {

	@PersistenceContext
	private EntityManager entityManager;

	
	public Users get(String email) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> criteria = criteriaBuilder.createQuery(Users.class);
		Root<Users> root = criteria.from(Users.class);
		criteria.select(root).where(criteriaBuilder.equal(root.get("emailId"), email));
		return entityManager.createQuery(criteria).getSingleResult();
	}
	
	@Override
	public List<Users> findAll(UserType userType) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> criteria = criteriaBuilder.createQuery(Users.class);
		Root<Users> root = criteria.from(Users.class);
		criteria.select(root).where(criteriaBuilder.equal(root.get("userType"), userType.getValue()));
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Users> findAll(UserType userType, String inputParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAll(String inputParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
