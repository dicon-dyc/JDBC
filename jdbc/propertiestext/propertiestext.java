package com.dicon.jdbc.propertiestext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiestext {
    public static void main(String[] args) throws IOException {

        //读取配置文件需要借助properties工具类完成
        //1.实例化Properties类的对象
        Properties prop = new Properties();

        //2.实例化Input类型的对象
        InputStream is = com.dicon.jdbc.propertiestext.propertiestext.class.getClassLoader().getResourceAsStream("propertiestext.properties");

        try{

            //3.以流方式加载配置文件
            prop.load(is);

            System.out.println(prop);

            //4.读取配置文件
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String pwd = prop.getProperty("pwd");

            //5.输出
            System.out.println("driver="+driver);
            System.out.println("url="+url);
            System.out.println("user="+user);
            System.out.println("pwd="+pwd);

        } catch (IOException e) {

            e.printStackTrace();
        }
        finally {

            //6.关闭io流
            is.close();
        }
    }
}
