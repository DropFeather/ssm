package com.zy.service.impl;

import java.util.List;
import java.util.Map;

import com.zy.dao.SysPermissionDao;
import com.zy.model.AuthUser;
import com.zy.model.SysPermission;
import com.zy.service.SysPermissionService;
import com.zy.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	public List<SysPermission> getSysPermission(Integer id,String permission_name) {
		return sysPermissionDao.getSysPermission(id, permission_name);
	}

	public List<Map<String, Object>> getSysPermissionTree() {
		return sysPermissionDao.getSysPermissionTree();
	}

	@Override
	public List<SysPermission> getSysPermissionMenu(AuthUser user) {
		return sysPermissionDao.getSysPermissionMenu(user);
	}

	@Override
	public List<SysPermission> getSysPermissionSecondMenu(String parentid,AuthUser user) {
		return sysPermissionDao.getSysPermissionSecondMenu(parentid,user);
	}

	@Override
	public int setPermission(String role_id, String[] ids) {
	 int num = sysPermissionDao.deletePermissionByRoleId(role_id);
	 num+=sysPermissionDao.setPermissionBatch(role_id,ids);
		return num;
	}

	@Override
	public int addPermission(SysPermission sysPermission) {
		return sysPermissionDao.addPermission(sysPermission);
	}

	@Override
	public int updatePermissionById(SysPermission sysPermission) {
		return sysPermissionDao.updatePermissionById( sysPermission);
	}

	@Override
	public int deletePermissionById(int id) {
		return sysPermissionDao.deletePermissionById(id);
	}

	@Override
	public int deletePermissionByPermissionId(String id) {
		return sysPermissionDao.deletePermissionByPermissionId(id);
	}

	@Override
	public List<SysPermission> getPermissionbyPid(String pid,String uid) {
		return sysPermissionDao.getSysPermissionbyPid(pid,uid);
	}

	@Override
	public List<SysPermission> getSysPermissionVo(Integer id, String pid) {
		return sysPermissionDao.getSysPermissionVo( id,  pid);
	}

	@Override
	public int deletePermissionByRoleId(String id) {
		return sysPermissionDao.deletePermissionByRoleId(id);
	}

	public List<Map<String, Object>> getSysPermissionTreeByRoleId(String role_id) {
		return sysPermissionDao.getSysPermissionTreeByRoleId(role_id);
	}

}
