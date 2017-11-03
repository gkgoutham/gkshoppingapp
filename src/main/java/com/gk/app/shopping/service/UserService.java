package com.gk.app.shopping.service;

import java.util.List;

import com.gk.app.shopping.bean.Users;

public interface UserService {

	public void createUser(Users user);

	public Users get(String emailId);

	public List<Users> getAllUsers();

	public List<Users> getAllUsers(String userType);

	public List<Users> getAllUsersByPartner(String parnterName);

	public boolean approveUser(Users user);

	public boolean rejectUser(Users user);

	public boolean enableUser(Users user);

	public boolean disableUser(Users user);

	public Users updateUser(Users user);

	public List<Users> findUser(String inputParam);
}
