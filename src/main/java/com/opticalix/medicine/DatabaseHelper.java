package com.opticalix.medicine;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * @author Felix
 */
public class DatabaseHelper {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bupt_project";
    static final String USER = "root";
    static final String PWD = "jhf223";
    public static final String TABLE_NAME_JD_MEDICINE = "medicine";
    public static final String TABLE_NAME_YJJ_MEDICINE = "yjj_medicine";

    public static DataSource getDataSource() {
        return getDataSource(DB_URL, USER, PWD);
    }

    public static DataSource getDataSource(String dbUrl, String user, String pwd) {
        MysqlDataSource dataSource = new MysqlDataSource();
        //不加encoding会查询不到select语句中文作为参数的情况
        dataSource.setCharacterEncoding("utf-8");
        dataSource.setUrl(dbUrl);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }
}
