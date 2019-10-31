package com;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class DatabaseHandler {
    java.sql.Statement stmt=null;
    java.sql.Connection con=null;

    public DatabaseHandler() throws SQLException {

        staticClass.url="jdbc:mysql://"+staticClass.host+":"+staticClass.port+"/"+staticClass.database;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(staticClass.url,staticClass.user,staticClass.password);
        }catch (Exception e){
            staticClass.commonString=e.getMessage();
        }
        stmt = con.createStatement();
    }

    public ResultSet read(String sqlQuery){
        ResultSet rs=null;
        try {
            rs = stmt.executeQuery(sqlQuery);

            String st = "";
            staticClass.waitVar=false;
            return rs;
        }catch(Exception e) {
            staticClass.commonString="Error: " + e.getMessage();
        }
        staticClass.waitVar=false;
        return null;
    }

    public Boolean write(String sqlQuery){
        try {
            boolean bs = stmt.execute(sqlQuery);
            return true;
        }catch(Exception e) {
            staticClass.commonString="Error: "+e.getMessage();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"DATA INCOMPLETE", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}

class staticClass {
    public static boolean waitVar=false;
    public static String commonString=null;



    public static Map<String,String> parent=new HashMap<>();
//    public static String status;
    public static String aff_num;
    public static String table;
    public static String myParent;
    public static String host="localhost";
    public static String port="3306";
    public static String database="EMS";
    public static String url="jdbc:mysql://localhost:3306/EMS";
    public static String user="root";
    public static String password="hello";

    public static char gender='M';
}

