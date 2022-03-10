package JDBCDemo;

import java.sql.*;

public class DatabaseDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
            System.out.println("Connection successful.");
            Statement stat = con.createStatement();
            stat.executeUpdate("CREATE DATABASE SUBJECT");
            System.out.println("Database created.");
            stat.executeUpdate("CREATE TABLE SUBJECT.PersonalDetails "+
                    "(id INTEGER not NULL, "
                    + " name VARCHAR(20), "
                    + " age INTEGER, "
                    + " city VARCHAR(20), "
                    + " PRIMARY KEY ( id ))");
            System.out.println("TABLE created.");
            stat.executeUpdate("INSERT INTO SUBJECT.PersonalDetails "
                    + " VALUES( 1001,'John',21,'Bangalore')");
            System.out.println("Values inserted successfully.");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            con.close();
        }
    }
}
