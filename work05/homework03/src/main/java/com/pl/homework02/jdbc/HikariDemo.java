package com.pl.homework02.jdbc;

import java.sql.*;

public class HikariDemo {
    public static void main(String[] args) {
//        insert();
        select();
    }
    private static void insert() {
        Connection connection = null;
        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
        try {
            connection = HikariUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement("insert into user (id,username,state) " +
                    "values (?,?,?)");

            for (int i = 0; i < 100; i++) {
                ps.setInt(1, i);
                ps.setString(2, "wangwu");
                ps.setString(3, "0");
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
            System.out.println("耗时：" + (System.currentTimeMillis() - start));
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            HikariUtils.close(connection, ps, null);
        }
    }

    private static void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = HikariUtils.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from user ");
            while (rs.next()) {
                System.out.println(rs.getInt(1));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            HikariUtils.close(connection, statement, rs);
        }
    }
}
