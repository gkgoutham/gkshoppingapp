package com.gk.app.shopping.dao;

import java.util.List;

import com.mongodb.WriteResult;

public interface MongoRepository<T> {

	public List<T> getAll();

	public void save(T object);

	public T get(String id);

	public WriteResult update(String id, String name);

	public void delete(String id);

	public void createCollection();

	public void dropCollection();
}
