package com.zy.dao;

import com.zy.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleDao {
    /**
     * 角色管理数据
     * @return
     */
     List<SysRole> getSysRole(@Param("id") Integer id);

    int sysroleAdd(SysRole role);

    int updateSysRoleByPrimaryKey(SysRole sysRole);

    int deleteById(int ids);

    int deleteUserByRoleId(String id);
}
