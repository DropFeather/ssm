package com.zy.model;


public class SysRole {
    private String id;
    private String name;
    private String content;
    private String available;

    public SysRole() {
    }

    public SysRole(String id, String name, String content, String available) {
        this.id = id;
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}