package com.zy.util;

import com.zy.model.SysPermission;

import java.util.List;

/**
 * @author zy
 * @Date 2019-11-18 16:07
 */
public class MenuUtil {
    private String id;
    private String name;
    private List<SysPermission> permission ;

    public MenuUtil() {
    }

    public MenuUtil(String id, String name, List<SysPermission> permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysPermission> getPermission() {
        return permission;
    }

    public void setPermission(List<SysPermission> permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "MenuUtil{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permission=" + permission +
                '}';
    }
}
