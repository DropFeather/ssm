package com.zy.controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.model.AuthUser;
import com.zy.model.SysPermission;
import com.zy.model.SysRole;
import com.zy.service.AuthUserService;
import com.zy.service.SysPermissionService;
import com.zy.service.SysRoleService;
import com.zy.util.AuthUserFunctionModel;
import com.zy.util.MenuUtil;
import com.zy.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysPermissionService sysPermissionService;
	@Autowired
	private AuthUserService authUserService;
	/**
	 * 添加角色
	 * @return
	 */
	@GetMapping("/authority-role-add")
	public String roleAdd() {
		return "/authority/authority-role-add";
	}
	/**
	 * 添加角色的跳转
	 * @return
	 */
	@PostMapping("/authority-role-add")
	@ResponseBody
	public int roleAdd(@RequestBody SysRole sysRole) {
		return sysRoleService.sysroleAdd(sysRole);
	}
	/**
	 * 修改角色的跳转
	 * @return
	 */
	@GetMapping("/authority-role-edit")
	public String roleEdit() {
		return "/authority/authority-role-edit";
	}
    /**
     * 修改角色
     * @return
     */
    @PostMapping("/authority-role-edit")
    @ResponseBody
    public int roleEdit(@RequestBody SysRole sysRole) {
        return sysRoleService.updateSysRoleByPrimaryKey(sysRole);
    }
	/**
	 * 删除角色
	 * @return
	 */
	@RequestMapping("/authority-role-delete")
    @ResponseBody
	public int authority_role_delete(String ids) {
		System.out.println("ids"+ids);
		String[] split = ids.split(",");
		int i=0;
		for (String id : split) {
			i+=sysPermissionService.deletePermissionByRoleId(id);
			i+=sysRoleService.deleteUserByRoleId(id);
			i += sysRoleService.deleteRoleById(Integer.parseInt(id));
		}
	    return i;
	}
	/**
	 * 角色界面的跳转
	 * @return
	 */
	@RequestMapping("/rolepage")
	public String rolePage() {
		return "/authority/authority-role";
	}

	/**
	 * 用户界面的跳转
	 * @return
	 */
	@GetMapping("/authority-user")
	public String userPage() {
		return "/authority/authority-user";
	}
	/**
	 * 用户数据
	 * @return
	 */
	@PostMapping("/authority-user")
	@ResponseBody
	public List<AuthUser> userData(String id) {
		System.out.println("id"+id);
		return authUserService.getUserRole(id);
	}
	/**
	 * 用户添加跳转
	 * @return
	 */
	@GetMapping("/authority-user-add")
	public String authority_user_add() {
		return "/authority/authority-user-add";
	}
	/**
	 * 用户添加
	 * @return
	 */
	@PostMapping("/authority-user-add")
	@ResponseBody
	public int authority_user_add(@RequestBody AuthUser authUser) {
	    int i = authUserService.addUser(authUser);
        authUser.setId(authUserService.selectByName(authUser.getUsername()).getId());
        i+=authUserService.addUserRole(authUser);
	    return i;
	}
	/**
	 * 用户修改跳转
	 * @return
	 */
	@GetMapping("/authority-user-edit")
	public String authority_user_edit() {
		return "/authority/authority-user-edit";
	}
	/**
	 * 用户修改
	 * @return
	 */
	@PostMapping("/authority-user-edit")
	@ResponseBody
	public int authority_user_edit(@RequestBody AuthUser authUser) {
	    int i = authUserService.editUser(authUser);
	    i+=authUserService.editUserRole(authUser);
	    return i;
	}

	@RequestMapping("/authority-user-delete")
	@ResponseBody
	public int authority_user_add(String ids) {
		String[] split = ids.split(",");
		int i=0;
		for (String id : split) {
			i+=authUserService.deleteUserRoleByUserId(id);
			i+=authUserService.deleteUserByUserId(id);
		}
		return i;
	}
	/**
	 * 权限界面的跳转
	 * @return
	 */
	@RequestMapping("/permissionpage")
	public String permissionPage() {
		return "/authority/authority-permission";
	}

	/**
	 * 权限添加
	 * @return
	 */
	@PostMapping("/authority-permission-add")
    @ResponseBody
	public int authority_permission_add(@RequestBody SysPermission sysPermission) {
		return sysPermissionService.addPermission(sysPermission);
	}
    /**
     * 权限添加界面跳转
     * @return
     */
    @GetMapping("/authority-permission-add")
    public String authority_permission_add() {
        return "/authority/authority-permission-add";
    }
	/**
	 * 权限修改
	 * @return
	 */
	@GetMapping("/authority-permission-edit")
	public String authority_permission_edit( ) {
		return "/authority/authority-permission-edit";
	}
	/**
	 * 权限修改
	 * @return
	 */
    @PostMapping("/authority-permission-edit")
    @ResponseBody
    public int authority_permission_edit(@RequestBody SysPermission sysPermission) {
    	return sysPermissionService.updatePermissionById(sysPermission);

    }
	/**
	 * 权限删除
	 * @return
	 */
    @RequestMapping("/authority-permission-delete")
    @ResponseBody
    public int authority_permission_delete(String ids) {
		System.out.println("ids"+ids);
		String[] split = ids.split(",");
		int i=0;
		for (String id : split) {
			i+=sysPermissionService.deletePermissionByPermissionId(id);
			i += sysPermissionService.deletePermissionById(Integer.parseInt(id));
		}
		return i;
    }
	/**
	 * 权限分配的界面跳转
	 * @return
	 */
	@RequestMapping("/settingspage")
	public String settingsPage() {
		return "/authority/authority-settings";
	}
	/**
	 * 动态树型菜单
	 * @return
	 */
	@RequestMapping("/menu-tree")
	@ResponseBody
	public List<MenuUtil> menuTree(HttpServletRequest request){
		List<MenuUtil> menuUtils=new ArrayList<>();
		AuthUserFunctionModel authUserFunctionModel = (AuthUserFunctionModel)request.getSession().getAttribute("authUserFunctionModel");
		AuthUser user = authUserFunctionModel.getAuthUser();
		System.out.println("user:"+user);
		if (user!=null){
			List<SysPermission> fristMenu = sysPermissionService.getSysPermissionMenu(user);
			for (SysPermission menu : fristMenu) {
				MenuUtil menuUtil=new MenuUtil();
				menuUtil.setId(menu.getId());
				menuUtil.setName(menu.getName());
				menuUtil.setPermission(sysPermissionService.getSysPermissionSecondMenu(menu.getId(),user));
				menuUtils.add(menuUtil);
			}
		}

		return menuUtils;

	}
	/**
	 * 角色数据的查询
	 * @return
	 */
	@RequestMapping(value = "/getsysrole")
	@ResponseBody
	public List<SysRole> getSysRole(@RequestParam(value = "id",defaultValue ="0") Integer id
	) {
		System.out.println("id:"+id);
		return sysRoleService.getSysRole(id);
	}

	/**
	 * 权限列表数据的查询
	 * @return
	 */
	@RequestMapping("/getsyspermission")
	@ResponseBody
	public PageInfo<SysPermission> getSysPermission(
			@RequestParam(value = "id",defaultValue = "0") Integer id,
			@RequestParam(value = "page",defaultValue = "1") Integer page,
			@RequestParam(value = "rows",defaultValue = "5") Integer rows,
			@RequestParam(value = "permission_name",defaultValue = "") String permission_name
	) {
		System.out.println("id"+id);

		PageHelper.startPage(page,rows);
		List<SysPermission> sysPermissionList = sysPermissionService.getSysPermission(id,permission_name);

		PageInfo<SysPermission> pageInfo = new PageInfo<>(sysPermissionList);
		return pageInfo;
	}

	/**
	 * 权限树的数据
	 * @return
	 */
	@RequestMapping("/getsyspermissiontree")
	@ResponseBody
	public List<Map<String,Object>> getSysPermissionTree() {
		return sysPermissionService.getSysPermissionTree();
	}

	/**
	 * 角色对应的权限值
	 * @param role_id
	 * @return
	 */
	@RequestMapping("/getsyspermissiontreebyroleid")
	@ResponseBody
	public List<Map<String, Object>> getSysPermissionTreeByRoleId(String role_id) {
		return sysPermissionService.getSysPermissionTreeByRoleId(role_id);
	}

	/**
	 * 分配权限（修改角色对应的权限）
	 * @param role_id
	 * @param permission_ids
	 * @return
	 */
	@RequestMapping("/updatepermissionbyroleid")
	@ResponseBody
	public int updatePermissionByRoleId(String role_id, String permission_ids) {
		System.out.println("role_id = " + role_id);
		System.out.println("permission_ids = " + permission_ids);
		String[] ids = permission_ids.split(",");
		return sysPermissionService.setPermission(role_id ,ids);



	}
//	按钮集权限
	@GetMapping("/authority-btn.do")
	@ResponseBody
	public List<SysPermission> authority_btn(String pid,HttpServletRequest request) {
		System.out.println("pid"+pid);
		AuthUserFunctionModel authUserFunctionModel = (AuthUserFunctionModel)request.getSession().getAttribute("authUserFunctionModel");
		AuthUser user = authUserFunctionModel.getAuthUser();
		System.out.println("authUserFunctionModel"+authUserFunctionModel);
		return sysPermissionService.getPermissionbyPid(pid, user.getId());
	}

}

