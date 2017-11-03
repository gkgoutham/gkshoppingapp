package com.gk.app.shopping.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface Repository<T> {
	
	public EntityManager getEntityManager();

	public List<T> getAll();
	
	public void delete(String id);

	default void save(T object){
		getEntityManager().persist(object);
	}

	default T get(Class<T> entityClass,Object id){
		return getEntityManager().find(entityClass,id);
	}

	default T update(T object){
		return getEntityManager().merge(object);
	}

}
