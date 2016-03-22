package eu.epfc.cours3449.LibrarySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");

        Statement statement = connx.createStatement();

        statement.executeUpdate("create table if not exists Temp (col1 char(5), col2 char(5))");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");
        while (resultSet.next()) {
            System.out.println(     resultSet.getString(1) 
                            + "\t" + resultSet.getString(2) 
                            + "\t" + resultSet.getString(3)
                            + "\t" + resultSet.getString(4)
                            + "\t" + resultSet.getString(5)
                            + "\t" + resultSet.getString(6)
            );   
        }
        
        
    }
}
