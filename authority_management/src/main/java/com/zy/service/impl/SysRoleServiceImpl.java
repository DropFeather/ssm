package com.zy.service.impl;

import java.util.List;

import com.zy.dao.SysRoleDao;
import com.zy.model.SysRole;
import com.zy.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleDao sysRoleDao;

	public List<SysRole> getSysRole(int id) {
		return sysRoleDao.getSysRole(id);
	}

	@Override
	public int sysroleAdd(SysRole role) {
		return sysRoleDao.sysroleAdd(role);
	}

	@Override
	public int updateSysRoleByPrimaryKey(SysRole sysRole) {
		return sysRoleDao.updateSysRoleByPrimaryKey(sysRole);
	}

	@Override
	public int deleteRoleById(int id) {
		return sysRoleDao.deleteById(id);
	}

	@Override
	public int deleteUserByRoleId(String id) {
		return sysRoleDao.deleteUserByRoleId(id);
	}
}
