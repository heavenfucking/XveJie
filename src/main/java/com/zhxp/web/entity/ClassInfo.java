package com.zhxp.web.entity;

/**
 * Created by zhh on 2017/4/17.
 */
public class ClassInfo {

    private Integer id;

    private String name;

    private String department;

    private String enterTime;

    public ClassInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }
}
