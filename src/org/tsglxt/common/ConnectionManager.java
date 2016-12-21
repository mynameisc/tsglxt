package org.tsglxt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class ConnectionManager{
    private static final String driver_class="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://127.0.0.1:3306/tsglxt";
    private static final String user="root";
    private static final String password="songsong";
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver_class);
            conn=DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if(conn!=null&&!(conn.isClosed())){
                conn.close();               
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs=null;
        }
    }
    public static void closeStatement(PreparedStatement pStatement){
        if(pStatement!=null){
            try {
                pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pStatement=null;
        }
    }
}