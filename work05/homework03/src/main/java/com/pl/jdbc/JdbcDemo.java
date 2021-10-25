package com.pl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        String sqlStatement;
        //通过工具类获取数据库连接对象
        Connection con = JdbcUtil.getConnection();
        //通过连接创建数据库执行对象
        Statement sta = con.createStatement();
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        //查询
        sqlStatement = "SELECT * FROM user";
        qry(sta, sqlStatement, rs);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        //增加
        sqlStatement = "INSERT INTO user VALUES('50','TEST','CHINA')";
        System.out.println("插入执行结果:" + update(sta, sqlStatement));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        //更新
        sqlStatement = "UPDATE user SET loc='SHAOXING' WHERE uid = '50'";
        System.out.println("更新执行结果:" + update(sta, sqlStatement));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        //删除
        sqlStatement = "DELETE FROM user WHERE uid = '50'";
        System.out.println("删除执行结果:" + update(sta, sqlStatement));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        JdbcUtil.closeResource(con, sta, rs);
    }

    /**
     * 查询
     *
     * @param sta
     * @param sql
     * @param rs
     * @throws SQLException
     */
    private static void qry(Statement sta, String sql, ResultSet rs) throws SQLException {
        rs = sta.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getObject("uid"));
        }
    }

    /**
     * 增删改
     *
     * @param sta
     * @param sql
     * @return
     * @throws SQLException
     */
    private static int update(Statement sta, String sql) throws SQLException {
        return sta.executeUpdate(sql);
    }
}
