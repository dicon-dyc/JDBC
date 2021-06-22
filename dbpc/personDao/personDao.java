package com.dicon.dbpc.personDao;

import com.dicon.dbpc.bean.person;
import com.dicon.dbpc.util.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Dao:Data Access Object(数据访问对象)
 * 作用：与数据库进行交互（数据的添加、修改、删除都写在该类中）
 * 方法所需的参数通过实体类进行传递
 */

public class personDao {

    /**
     * 向数据库中添加数据
     */
    public int add(person per){

        try {
            //1.获取数据库连接对象
            Connection conn = util.getConnection();

            //2.编写sql语句
            String sql = "INSERT INTO person VALUES(DEFAULT,?,?,?,?)";

            //3.获取PreparedStatement对象
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1,per.getSname());
            prep.setString(2,per.getSex());
            prep.setInt(3,per.getHusband());
            prep.setInt(4,per.getWife());

            //4.执行sql语句
            return prep.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
