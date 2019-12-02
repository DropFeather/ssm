package com.zy.service;

import com.zy.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysRoleService {

     List<SysRole> getSysRole(int id);

    int sysroleAdd(SysRole role);

    int updateSysRoleByPrimaryKey(SysRole sysRole);

    int deleteRoleById(int id);

    int deleteUserByRoleId(String id);
}
