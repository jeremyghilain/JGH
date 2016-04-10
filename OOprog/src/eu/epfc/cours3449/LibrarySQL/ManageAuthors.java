
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
    public static void main() throws ClassNotFoundException, SQLException {
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
            case "A": DisplayAuthors(getAllAuthors()); break;
            case "S": DisplayAuthors(SelectAuthors()); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    private static void AddAuthors() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String val=new String();
        System.out.println("Addition of authors");
        Author a=new Author();
        System.out.println("Please enter the ID of the new author");
        val = input.nextLine();
        while (!getAuthorFromQuery("authorid", val).isEmpty()) {
            System.out.println("This ID is already used, please enter a valid ID");
            val = input.nextLine();
        }
        a.setAuthorid(val);        
        System.out.println("");
        System.out.println("Please enter the name of the new author");
        a.setName(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the family name of the new author");
        a.setFamilyName(input.nextLine());
        System.out.println("");
        System.out.println("The new author is:");
        a.toDisplay();
        setAuthorToQuery(a);
    }
    
    private static void ModifyAuthors() throws ClassNotFoundException, SQLException{        
        Scanner input = new Scanner(System.in);
        String option=new String();
        String var=new String();
        String val=new String();
        System.out.println("Modification of authors");        
        System.out.println("What is the author you which to modify");
        ArrayList<Author> selection = SelectAuthors();
        System.out.println("What is the variable you which to modify?");
        System.out.println("For the ID, enter 'I'. For the name, enter 'N'. For the family name, enter 'F'");
        option = input.nextLine();
        switch (option) {
            case "I": var="authorid";break;
            case "N": var="name";break;
            case "F": var="family_name";break;
            default : System.out.println("The value entered is not valid, please enter a correct one");
        }
        System.out.println("");
        System.out.println("What is the new value of this variable? ");
        val = input.nextLine();
        
        modifyAuthorInQuery(selection, var, val);        
    }
    
    private static void DeleteAuthors() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Deletion of authors");
        ArrayList<Author> selection = SelectAuthors();
        System.out.println("");
        System.out.println("The following authors will be deleted.");
        DisplayAuthors(selection);
        System.out.println("Do you confirm?");
        option=input.nextLine();
        if(option.equals("Y")) {
            for (Author a : selection ) {
                deleteAuthorByQuery(a);
            }
        } else {
            System.out.println("The authors were not deleted");}
    }
    
    private static ArrayList<Author> SelectAuthors() throws ClassNotFoundException, SQLException {
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
            case "F": var="family_name";break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
        System.out.println("Please enter the value you are look for");
        val= input.nextLine();
        System.out.println("");
        return getAuthorFromQuery(var, val);
    }
    
    public static ArrayList<Author> getAuthorFromQuery(String var, String val) throws ClassNotFoundException, SQLException {
        ArrayList<Author> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM AUTHORS WHERE "+var+"='"+val+"'");
        while (resultSet.next()) {
            Author a = new Author();
            selection.add(a);
            a.setAuthorid(resultSet.getString(1));
            a.setName(resultSet.getString(2));
            a.setFamilyName(resultSet.getString(3));
        }
        return selection;
    }
    
    private static void modifyAuthorInQuery(ArrayList<Author> selection, String var, String val) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        for (Author a : selection) {
            statement.execute("UPDATE AUTHORS SET "+var+"='"+val+"' WHERE AUTHORID='"+a.getAuthorid()+"'");
        }
    }
    
    private static void setAuthorToQuery(Author a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("insert into AUTHORS (authorid,name,family_name) values ('"+a.getAuthorid()+"','"+a.getName()+"','"+a.getFamilyName()+"') ;");
    }
    
    private static ArrayList<Author> getAllAuthors() throws ClassNotFoundException, SQLException {
        ArrayList<Author> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM AUTHORS");
        while (resultSet.next()) {
            Author a = new Author();
            selection.add(a);
            a.setAuthorid(resultSet.getString(1));
            a.setName(resultSet.getString(2));
            a.setFamilyName(resultSet.getString(3));
        }
        return selection;
    }
    
    private static void deleteAuthorByQuery(Author a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("DELETE FROM AUTHORS WHERE authorid='"+a.getAuthorid()+"'");
    }
    
    private static void DisplayAuthors(ArrayList<Author> selection) {
        System.out.println("Author ID ; Name ; Family name");
        for (Author a : selection) {
            a.toDisplay();
        }
        System.out.println("");
    }
}
