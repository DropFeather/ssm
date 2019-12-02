package com.zy.service;

import com.zy.model.AuthUser;

import java.util.List;
import java.util.Map;


public interface AuthUserService {

	public AuthUser getAuthUser(AuthUser authUser);

	public List<Map<String,Object>> getAuthUserFunction(AuthUser authUser);

    List<AuthUser> getUserRole(String id);

	int addUser(AuthUser authUser);

	int deleteUserRoleByUserId(String id);

	int deleteUserByUserId(String id);

	int editUser(AuthUser authUser);

	int addUserRole(AuthUser authUser);

	int editUserRole(AuthUser authUser);

	AuthUser selectByName(String username);
}
