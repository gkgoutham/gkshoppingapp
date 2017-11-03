package com.gk.app.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.gk.app.shopping.bean.Tree;
import com.gk.app.shopping.dao.MongoRepository;
import com.mongodb.WriteResult;

@Service
public class NatureRepositoryImpl implements MongoRepository<Tree> {

	@Autowired
	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * Get all trees.
	 */
	public List<Tree> getAll() {
		return mongoTemplate.findAll(Tree.class);
	}

	/**
	 * Saves a {@link Tree}.
	 */
	public void save(Tree tree) {
		mongoTemplate.insert(tree);
	}

	/**
	 * Gets a {@link Tree} for a particular id.
	 */
	public Tree get(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Tree.class);
	}

	/**
	 * Updates a {@link Tree} name for a particular id.
	 */
	public WriteResult update(String id, String name) {
		return mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), Update.update("name", name),
				Tree.class);
	}

	/**
	 * Delete a {@link Tree} for a particular id.
	 */
	public void delete(String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Tree.class);
	}

	/**
	 * Create a {@link Tree} collection if the collection does not already
	 * exists
	 */
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Tree.class)) {
			mongoTemplate.createCollection(Tree.class);
		}
	}

	/**
	 * Drops the {@link Tree} collection if the collection does already exists
	 */
	public void dropCollection() {
		if (mongoTemplate.collectionExists(Tree.class)) {
			mongoTemplate.dropCollection(Tree.class);
		}
	}

}