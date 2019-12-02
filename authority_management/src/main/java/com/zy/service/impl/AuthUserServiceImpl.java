package com.zy.service.impl;

import java.util.List;
import java.util.Map;

import com.zy.dao.AuthUserDao;
import com.zy.model.AuthUser;
import com.zy.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private AuthUserDao authUserDao;
	
	public AuthUser getAuthUser(AuthUser authUser) {
		return authUserDao.getAuthUser(authUser);
	}

	public List<Map<String, Object>> getAuthUserFunction(AuthUser authUser) {
		return authUserDao.getAuthUserFunction(authUser);
	}

	@Override
	public List<AuthUser> getUserRole(String id) {
		return authUserDao.getUserRole(id);
	}

	@Override
	public int addUser(AuthUser authUser) {
		return authUserDao.addUser(authUser);
	}

	@Override
	public int deleteUserRoleByUserId(String id) {
		return authUserDao.deleteUserRoleByUserId(id);
	}

	@Override
	public int deleteUserByUserId(String id) {
		return authUserDao.deleteUserByUserId(id);
	}

	@Override
	public int addUserRole(AuthUser authUser) {
		return authUserDao.addUserRole(authUser);
	}

	@Override
	public int editUserRole(AuthUser authUser) {
		return authUserDao.editUserRole(authUser);
	}

	@Override
	public AuthUser selectByName(String username) {
		return authUserDao.selectByName(username);
	}

	@Override
	public int editUser(AuthUser authUser) {
		return authUserDao.editUser(authUser);
	}

}
