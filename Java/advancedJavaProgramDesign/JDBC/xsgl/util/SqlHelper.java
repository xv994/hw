package advancedJavaProgramDesign.JDBC.xsgl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SqlHelper {

    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xsgl?serverTimezone=GMT%2B8";
            Connection conn=DriverManager.getConnection(url,"root","Xvzh010325!");
           return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeResultSet(ResultSet rs){
        try{
            rs.close();          
        }catch(Exception e){
            e.printStackTrace();           
        }
    } 

    public static void closePreparedStatement(PreparedStatement ps){
        try{
            ps.close();          
        }catch(Exception e){
            e.printStackTrace();           
        }
    }

    public static void closeConnection(Connection conn){
        try{
            conn.close();          
        }catch(Exception e){
            e.printStackTrace();           
        }
    }

 }
