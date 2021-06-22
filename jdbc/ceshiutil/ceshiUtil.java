package com.dicon.jdbc.ceshiutil;

import com.dicon.jdbc.Util.Utiltext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ceshiUtil {
    public static void main(String[] args) {

        //存储受影响行
        int r = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            //1.获取数据库连接对象
            conn = Utiltext.getConnection();

            //2.编写SQL语句
            String sql = "SELECT * FROM person;";

            //3.创建PreparedStatement对象
            ps = conn.prepareStatement(sql);

            //4.创建ResultSet对象
            rs = ps.executeQuery();

            //5.输出
            while(rs.next()){
                System.out.print(rs.getInt("id")+"\t");
                System.out.print(rs.getString("sname")+"\t");
                System.out.print(rs.getString("sex")+"\t");
                System.out.print(rs.getInt("husband")+"\t");
                System.out.println(rs.getInt("wife"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {

            //关闭连接对象
            Utiltext.close(rs,ps,conn);
        }
    }
}
