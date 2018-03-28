package com.opticalix;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class Main {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bupt_project";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "jhf223";

    private static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(DB_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASS);
        return dataSource;
    }

    private static void testDbUtils() throws SQLException {

        String sql = "SELECT * FROM yjj_medicine limit 1";
        QueryRunner runner = new QueryRunner(getDataSource());
        ResultSetHandler<List<YjjMedicine>> h = new BeanListHandler<>(YjjMedicine.class);

        List<YjjMedicine> yjjMedicines = runner.query(sql, h);
        yjjMedicines.forEach(System.out::println);
    }

    public static void main(String[] args) {
        try {
            testDbUtils();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test_simple_select() {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM medicine limit 5";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("drug_name");

                // 输出数据
                System.out.print("id: " + id);
                System.out.print(", drug_name: " + name);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
