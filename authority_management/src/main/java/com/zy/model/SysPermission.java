package com.zy.model;

public class SysPermission {
    private String id;
    private String name;
    private String type;
    private String url;
    private String percode;
    private String parentid;
    private String parentids;
    private String sortstring;
    private String available;

    public SysPermission() {
    }

    public SysPermission(String id, String name, String type, String url, String percode, String parentid, String parentids, String sortstring, String available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.percode = percode;
        this.parentid = parentid;
        this.parentids = parentids;
        this.sortstring = sortstring;
        this.available = available;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getParentids() {
        return parentids;
    }

    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    public String getSortstring() {
        return sortstring;
    }

    public void setSortstring(String sortstring) {
        this.sortstring = sortstring;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", percode='" + percode + '\'' +
                ", parentid='" + parentid + '\'' +
                ", parentids='" + parentids + '\'' +
                ", sortstring='" + sortstring + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}