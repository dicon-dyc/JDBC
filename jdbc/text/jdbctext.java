package com.dicon.jdbc.text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbctext {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        add();
    }

    private static void add() throws ClassNotFoundException, SQLException {

        //1.使用反射技术加载驱动类
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        /**
         * 参数1：数据库Url
         * 参数2：用户名
         * 参数3：密码
         */
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.146.134:3306/person","root","123456");

        //3.编写sql语句
        String sql = "INSERT INTO person VALUES('7','小铭','1','0','0')";

        //4.创建perparedstatement对象
        PreparedStatement prep = conn.prepareStatement(sql);

        //5.执行
        prep.executeUpdate();

        //6.关闭连接对象
        prep.close();
        conn.close();
    }
}
