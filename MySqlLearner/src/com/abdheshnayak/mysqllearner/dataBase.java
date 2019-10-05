package com.abdheshnayak.mysqllearner;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dataBase {


    java.sql.Statement stmt=null;
    java.sql.Connection con=null;

    public dataBase() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        staticClass.url="jdbc:mysql://"+staticClass.host+":"+staticClass.port+"/"+staticClass.database;

//        System.out.println(staticClass.url);

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(staticClass.url,staticClass.user,staticClass.password);
        }catch (Exception e){
            staticClass.commonString=e.getMessage();
       }
        stmt = con.createStatement();

    }

    public String read(String sqlQuery){
//
//        staticClass.url="jdbc:mysql://"+staticClass.host+":"+staticClass.port+"/"+staticClass.database;

//        System.out.println(staticClass.url);
//        String url="";
//        String user="";
//        String password="";

        ResultSet rs=null;
        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            System.out.println("1");
//            con = DriverManager.getConnection(staticClass.url,staticClass.user,staticClass.password);
//            System.out.println("2");
//            con.setReadOnly(true);
//            stmt = con.createStatement();
//            System.out.println("3");
//            boolean bs = stmt.execute(sqlQuery);
            rs = stmt.executeQuery(sqlQuery);
//            System.out.println("4");


            String st = "";
            while (rs.next()){
                for(int i = 1;i<= rs.getMetaData().getColumnCount();i++){
                    st+= rs.getString(i)+"\t";
                }
                st+="\n";
            }

//            System.out.println("5");
            rs.close();
//            stmt.close();
//            con.close();

            staticClass.waitVar=false;
            return st;
        }catch(Exception e) {
            staticClass.commonString="Error: " + e.getMessage();
//            System.out.println(staticClass.commonString);
        }
        staticClass.waitVar=false;
        return null;
    }

    public Boolean write(String sqlQuery){
        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            System.out.println("1");
//            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/UVrm9kPDFH","UVrm9kPDFH","dfvqxINNDM");
//            System.out.println("2");
//            con.setReadOnly(true);
//            stmt = con.createStatement();
//            System.out.println("3");
            boolean bs = stmt.execute(sqlQuery);
//            ResultSet rs = stmt.executeQuery("Select * from emp");
//            System.out.println("4");

//            System.out.println("5");
//            rs.close();
//            stmt.close();
//            con.close();

            return true;
        }catch(Exception e) {
            staticClass.commonString="Error: "+e.getMessage();
//            System.out.println(staticClass.commonString);
        }
        return false;
    }

}
