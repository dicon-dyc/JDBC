package com.dicon.jdbc.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Utiltext {

    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    /**
     * 静态代码块
     */
    static {

        //1.实例化Properties对象
        Properties prop = new Properties();

        //2.获取输入流对象
        InputStream is = Utiltext.class.getClassLoader().getResourceAsStream("propertiestext.properties");

        try{

            //3.加载输入流对象
            prop.load(is);

            //4.读取配置文件信息
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            pwd = prop.getProperty("pwd");

            //5.加载数据库驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pwd);
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn){

        //关闭ResultSet对象
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //关闭PreparedStatement对象
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //关闭Connection对象
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}

