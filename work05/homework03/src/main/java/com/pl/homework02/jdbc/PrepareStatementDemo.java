package com.pl.homework02.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementDemo {
    private static String sqlStatement;

    public static void main(String[] args) throws SQLException {
        //通过工具类获取数据库连接对象
        Connection con = null;
        //通过连接创建数据库执行对象
        PreparedStatement ps = null;
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        try {
            JdbcUtil.getConnection();
            con.setAutoCommit(false);
            //查询
            sqlStatement = "SELECT * FROM user WHERE uid = ?";
            ps = con.prepareStatement(sqlStatement);
            ps.setObject(1, "10");
            //增加
            sqlStatement = "INSERT INTO user VALUES(?,?,?)";
            ps = con.prepareStatement(sqlStatement);
            for (int i = 0; i < 1000; i++) {
                ps.setObject(1, i);
                ps.setObject(2, "lisi");
                ps.setObject(3, "0");
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(con, ps, rs);
        }
    }

}
