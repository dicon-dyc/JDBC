package com.dicon.dbpc.bean;

/**
 * 实体类
 * 一个数据库中的数据表对应于一个实体类
 * 命名：与数据表的名称相同（去掉鼠标的前缀和复数）；
 *
 * 规范：
 * 1、公共的类
 * 2、无参构造函数
 * 3、私有成员字段（私有成员字段与数据表中的字段一一对应）
 * 4、get/set访问器
 */

public class person {

    //私有成员字段
    private int id;
    private String sname;
    private String sex;
    private int husband;
    private int wife;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHusband() {
        return husband;
    }

    public void setHusband(int husband) {
        this.husband = husband;
    }

    public int getWife() {
        return wife;
    }

    public void setWife(int wife) {
        this.wife = wife;
    }
}
