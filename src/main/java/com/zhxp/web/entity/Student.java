package com.zhxp.web.entity;

/**
 * Created by zhu on 2017/3/28.
 */
public class Student {

    private Integer id;

    private String no;

    private String name;

    private Integer sex;

    private Integer department;

    private Integer _class;

    private String password;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer get_class() {
        return _class;
    }

    public void set_class(Integer _class) {
        this._class = _class;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
