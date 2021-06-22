package com.dicon.dbpc.text;

import com.dicon.dbpc.bean.person;
import com.dicon.dbpc.personDao.personDao;

/**
 * 编写测试类
 */

public class test {

    public static void main(String[] args) {

        //实例化一个Dao
        personDao dao = new personDao();

        //实例化一个实体类对象
        person per = new person();
        per.setSname("小博");
        per.setSex("0");
        per.setHusband(6);
        per.setWife(7);

        //调用Dao方法
        int i = dao.add(per);
        System.out.println("i="+i);
    }
}
