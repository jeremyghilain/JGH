
package eu.epfc.cours3449.LibrarySQL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageAuthors {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();

        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        while (cont) {
            System.out.println("Management of authors");
            System.out.println("To display authors, enter 'S'");
            System.out.println("To add authors, enter 'A'");
            System.out.println("To modify authors, enter 'M'");
            System.out.println("To delete authors, enter 'D'");
            System.out.println("To quit this menu, enter 'Q'");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "S": SummaryAuthors(); break;
                case "A": AddAuthors(); break;
                case "M": ModifyAuthors(); break;
                case "D": DeleteAuthors(); break;
                case "Q": cont=false; break;
                default : System.out.println("The value entered is not valid, please enter a correct one");
            }
        }
        
        
        
    }
    
    private static void SummaryAuthors() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Summary of Authors");
        System.out.println("To display all authors, enter 'A'");
        System.out.println("To select an specific author, enter 'S'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "A": DisplayAuthors(); break;
            case "S": SelectAuthors(); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    private static void AddAuthors(){
            
    }
    
    private static void ModifyAuthors(){
            
    }
    
    private static void DeleteAuthors(){
            
    }
    
    private static String SelectAuthors() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        Scanner input = new Scanner(System.in);
        String id=new String();
        String var=new String();
        String val=new String();
        String option=new String();
        System.out.println("Selection of authors");
        System.out.println("To search based on the ID, enter 'I'");
        System.out.println("To search based on the name, enter 'N'");
        System.out.println("To search based on the family name, enter 'F'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "I": var="authorid";break;
            case "N": var="name";break;
            case "F": var="familyname";break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
        System.out.println("Please enter the value you are look for");
        val= input.nextLine();
        System.out.println("");
        ResultSet resultSet = statement.executeQuery("SELECT authorid FROM BOOKS WHERE "+var+"='"+val+"'");
        while (resultSet.next()) {
            System.out.println(     resultSet.getString(1) 
                            + "\t" + resultSet.getString(2) 
                            + "\t" + resultSet.getString(3)
                            + "\t" + resultSet.getString(4)
                            + "\t" + resultSet.getString(5)
                            + "\t" + resultSet.getString(6)
            );
        }
        return id;
    }
    
    private static void getAuthorFromQuery(String var, String val) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT authorid FROM BOOKS WHERE "+var+"='"+val+"'");
    }
    
    private static void DisplayAuthors(){
        
    }
}
