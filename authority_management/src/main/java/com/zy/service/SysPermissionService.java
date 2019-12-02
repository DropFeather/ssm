package com.zy.service;

import com.zy.model.AuthUser;
import com.zy.model.SysPermission;
import com.zy.vo.PermissionVo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SysPermissionService {

    public List<SysPermission> getSysPermission(Integer id,String permission_name);
    

    public List<Map<String,Object>> getSysPermissionTree();
    

    public List<Map<String, Object>> getSysPermissionTreeByRoleId(String role_id);

    List<SysPermission> getSysPermissionMenu(AuthUser user);

    List<SysPermission> getSysPermissionSecondMenu(String parentid,AuthUser user);

    int setPermission(String role_id, String[] ids);

    int addPermission(SysPermission sysPermission);

    int updatePermissionById(SysPermission sysPermission);

    int deletePermissionById(int id);

    int deletePermissionByPermissionId(String id);

    int deletePermissionByRoleId(String id);

    List<SysPermission> getSysPermissionVo(Integer id, String pid);

    List<SysPermission> getPermissionbyPid(String pid,String uid);
}
