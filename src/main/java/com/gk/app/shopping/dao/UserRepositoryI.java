package com.gk.app.shopping.dao;

import java.util.List;

import com.gk.app.shopping.bean.UserType;
import com.gk.app.shopping.bean.Users;

public interface UserRepositoryI extends Repository<Users> {

	public List<Users> findAll(UserType userType);

	public List<Users> findAll(UserType userType, String inputParam);

	public List<Users> findAll(String inputParam);

}
