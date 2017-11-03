package com.gk.app.shopping.bean.mongo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gk.app.shopping.bean.Category;

public class PartnerProfile {

	private String partnerId;
	private String userName;

	private Set<Category> procuctCategories;
	private List<Product> products;

	private Map<String, List<Object>> documents;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Category> getProcuctCategories() {
		return procuctCategories;
	}

	public void setProcuctCategories(Set<Category> procuctCategories) {
		this.procuctCategories = procuctCategories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Map<String, List<Object>> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, List<Object>> documents) {
		this.documents = documents;
	}

}
