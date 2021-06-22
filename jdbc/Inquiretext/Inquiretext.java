package com.dicon.jdbc.Inquiretext;

import java.sql.*;

public class Inquiretext {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        inquire();
    }

    private static void inquire() throws ClassNotFoundException, SQLException {

        //1.通过反射技术加载驱动类
        Class.forName("com.mysql.jdbc.Driver");

        //2.连接数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.146.134:3306/person","root","123456");

        //3.编写sql
        String sql = "SELECT * FROM person;";

        //4.创建preparedstatement对象
        PreparedStatement prep = conn.prepareStatement(sql);

        //5.创建resultset对象接受数据
        ResultSet rs = prep.executeQuery();

        //6.输出数据
        while(rs.next()){
            System.out.print(rs.getInt("id")+"\t");
            System.out.print(rs.getString("sname")+"\t");
            System.out.print(rs.getString("sex")+"\t");
            System.out.print(rs.getInt("husband")+"\t");
            System.out.println(rs.getInt("wife"));
        }

        //7.关闭连接
        rs.close();
        prep.close();
        conn.close();
    }
}
