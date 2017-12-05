package cn.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class Privilege {
    private Integer id;//权限编号
    private String url;//对应的功能连接地址
    private String name;//权限名称（唯一）
    private String icon;//图标
    private Integer parent;//父权限对象
    private List<Privilege> children = new ArrayList<Privilege>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }
}
