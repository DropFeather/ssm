package com.zy.dao;

import com.zy.model.AuthUser;
import com.zy.model.SysPermission;
import com.zy.vo.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface SysPermissionDao {


    /**
     * 权限列表数据
     * @return
     */
    public List<SysPermission> getSysPermission(@Param("id") Integer id,@Param("permission_name") String permission_name);


    /**
     * 权限树的数据
     * @return
     */
    public List<Map<String,Object>> getSysPermissionTree();

    /**
     * 角色对应权限值
     * @param role_id
     * @return
     */
    List<Map<String, Object>> getSysPermissionTreeByRoleId(String role_id);

    List<SysPermission> getSysPermissionMenu(@Param("user") AuthUser user);

    List<SysPermission> getSysPermissionSecondMenu(@Param("parentid") String parentid,@Param("user")AuthUser user);

    int deletePermissionByRoleId(String role_id);

    int setPermissionBatch(String role_id,String[] ids);

    int addPermission(SysPermission sysPermission);

    int updatePermissionById(SysPermission sysPermission);

    int deletePermissionById(int id);

    int deletePermissionByPermissionId(String sys_permission_id);

    List<SysPermission> getSysPermissionVo(@Param("id") Integer id, @Param("pid") String pid);

    List<SysPermission> getSysPermissionbyPid(@Param("pid") String pid ,@Param("uid") String uid);
}
