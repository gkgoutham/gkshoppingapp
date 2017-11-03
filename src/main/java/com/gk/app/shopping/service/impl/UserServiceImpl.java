package com.gk.app.shopping.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.app.shopping.bean.UserType;
import com.gk.app.shopping.bean.Users;
import com.gk.app.shopping.dao.UserRepositoryI;
import com.gk.app.shopping.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoryI userDao;

	@Override
	public void createUser(Users user) {
		userDao.save(user);
	}
	
	@Override
	public Users get(String emailId){
		return userDao.get(Users.class, Integer.parseInt(emailId));
	}
	

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAllUsers(String userType) {
		UserType userTypeE= UserType.valueOf(userType);
		return userDao.findAll(userTypeE);
	}

	@Override
	public List<Users> getAllUsersByPartner(String parnterName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveUser(Users user) {
		Users usr=userDao.get(Users.class, user.getEmailId());
		usr.setIsApproved((byte)1);
		usr.setApprovedBy("gkgoutham");
		usr.setApprovedOn(new Date());
		userDao.update(usr);
		return true;
	}

	@Override
	public boolean rejectUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enableUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findUser(String inputParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
