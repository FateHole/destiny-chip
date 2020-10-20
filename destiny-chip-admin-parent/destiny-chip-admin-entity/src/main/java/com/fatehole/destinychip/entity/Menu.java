package com.fatehole.destinychip.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 父节点
     */
    private Integer pid;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点附带的url，点击发送的url请求
     */
    private String url;

    /**
     * 节点的图标样式
     */
    private String icon;

    /**
     * 子节点的集合
     */
    private List<Menu> subset = new ArrayList<>();

    /**
     * 控制节点默认为打开
     */
    private Boolean open = true;

    public Menu(Integer id, Integer pid, String name, String url, String icon) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.url = url;
        this.icon = icon;
    }

    public Menu() {
        super();
    }

    public Menu(Integer id, Integer pid, String name, String url, String icon, Boolean open) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public List<Menu> getSubset() {
        return subset;
    }

    public void setSubset(List<Menu> subset) {
        this.subset = subset;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", subset=" + subset +
                ", open=" + open +
                '}';
    }
}