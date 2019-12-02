package com.zy.util;

import com.zy.model.AuthUser;

import java.util.List;
import java.util.Map;

/**
 * 权限模型
 *   1.记录用户信息 AuthUser
 *   2.记录用户权限 AuthFunction
  *@author:pc
  *@date:2019-11-02
  */

public class AuthUserFunctionModel {

	private AuthUser authUser;
	private List<Map<String,Object>> authFunction;

	public AuthUserFunctionModel(AuthUser authUser, List<Map<String, Object>> authFunction) {
		super();
		this.authUser = authUser;
		this.authFunction = authFunction;
	}

	public AuthUser getAuthUser() {
		return authUser;
	}
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	public List<Map<String, Object>> getAuthFunction() {
		return authFunction;
	}
	public void setAuthFunction(List<Map<String, Object>> authFunction) {
		this.authFunction = authFunction;
	}

	@Override
	public String toString() {
		return "AuthUserFunctionModel{" +
				"authUser=" + authUser +
				", authFunction=" + authFunction +
				'}';
	}
}