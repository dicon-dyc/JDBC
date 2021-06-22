package com.dicon.dbpc.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class util {

    //数据库连接池
    private static DataSource ds;

    //通过ThreadLocal来保存每一个请求
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /**
     * 通过静态代码块初始化连接池
     */
    static {

        //实例化Properties对象
        Properties  prop = new Properties();

        //获取输入流对象
        InputStream is = util.class.getClassLoader().getResourceAsStream("dbcpText.properties");

        try {

            //以流方式加载配置文件
            prop.load(is);

            //实例化了数据库连接池对象
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过连接池获取Connection对象
     */
    public static Connection getConnection() throws SQLException {

        //线程从ThreadLocal中读取数据
        Connection  conn = threadLocal.get();

        //判断数据的状态是否有效
        if (conn == null||conn.isClosed()){

            //从连接池中获取一个新的连接对象
            conn = ds.getConnection();

            //将数据重新放到ThreadLocal中
            threadLocal.set(conn);
        }

        return conn;
    }

    /**
     * 释放连接
     */
    public static void close(){

        //线程从ThreadLocal中读取数据
        Connection conn = threadLocal.get();

        try {

            //判断数据的状态
            if (conn!=null&&!conn.isClosed()){

                //释放资源，将连接归还给连接池（不是真的关闭，而是将连接对象归还给连接池）
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //设置threadLoal中的数据为null
        threadLocal.set(null);
    }
}
