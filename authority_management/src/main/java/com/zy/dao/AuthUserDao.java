package com.zy.dao;

import com.zy.model.AuthUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthUserDao {

	AuthUser getAuthUser(AuthUser authUser);

	List<Map<String, Object>> getAuthUserFunction(AuthUser authUser);

	List<AuthUser> getUserRole(@Param("id") String id);

    int addUser(AuthUser authUser);

	int deleteUserRoleByUserId(String id);

	int deleteUserByUserId(String id);

	int editUser(AuthUser authUser);

	int addUserRole(AuthUser authUser);

	int editUserRole(AuthUser authUser);

	AuthUser selectByName(String username);
}
