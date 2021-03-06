
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

public class ManageBooks {
    public static void main(String args[ ]) throws ClassNotFoundException, SQLException {
        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        while (cont) {
            System.out.println("Management of books");
            System.out.println("To display books, enter 'S'");
            System.out.println("To add books, enter 'A'");
            System.out.println("To modify books, enter 'M'");
            System.out.println("To delete books, enter 'D'");
            System.out.println("To quit this menu, enter 'Q'");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "S": SummaryBooks(); break;
                case "A": AddBooks(); break;
                case "M": ModifyBooks(); break;
                case "D": DeleteBooks(); break;
                case "Q": cont=false; break;
                default : System.out.println("The value entered is not valid, please enter a correct one");
            }
        }
        
        
        
    }
    
    private static void SummaryBooks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Summary of Books");
        System.out.println("To display all books, enter 'A'");
        System.out.println("To select a specific book, enter 'S'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "A": DisplayBooks(getAllBooks()); break;
            case "S": DisplayBooks(SelectBooks()); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    private static void AddBooks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String val=new String();
        String opt=new String();
        System.out.println("Addition of books");
        Book a=new Book();
        System.out.println("Please enter the ID of the new book");
        val = input.nextLine();
        while (!getBookFromQuery("bookid", val).isEmpty()) {
            System.out.println("This ID is already used, please enter a valid ID");
            val = input.nextLine();
        }
        a.setBookid(val);
        
        System.out.println(" ");
        System.out.println("Please enter the ID of the work to which the book belongs");
        val = input.nextLine();
        while (ManageWorks.getWorkFromQuery("workid", val).isEmpty()) {
            System.out.println("This ID doesn't exist, please enter a valid ID");
            val = input.nextLine();
        }
        a.setWorkid(val);
        
        System.out.println("Is the edition of this book a new edition? (Y/N)");
        opt = input.nextLine();
        if (opt.equals("Y")) {
            ManageEditions.AddEditions();
        }
        System.out.println(" ");
        System.out.println("Please enter the ID of the edition of the book");
        val = input.nextLine();
        while (ManageEditions.getEditionFromQuery("editionid", val).isEmpty()) {
            System.out.println("This ID doesn't exist, please enter a valid ID");
            val = input.nextLine();
        }
        a.setEditionid(val);
        
        System.out.println("");
        System.out.println("Please enter the location of the book");
        a.setLocation(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the buy date of the book");
        a.setBuyDate(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the isbn of the book");
        a.setIsbn(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the format of the book");
        a.setFormat(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the language of the book");
        a.setLanguage(input.nextLine());
        System.out.println("");
        System.out.println("The new book is:");
        a.toDisplay();
        setBookToQuery(a);
    }
    
        private String bookid;
    private String workid;
    private String editionid;
    private String location;
    private String buyDate;
    private String isbn;
    private String format;
    private String language;
    
    private static void ModifyBooks() throws ClassNotFoundException, SQLException{        
        Scanner input = new Scanner(System.in);
        String option=new String();
        String var=new String();
        String val=new String();
        System.out.println("Modification of books");        
        System.out.println("What is the book you which to modify");
        ArrayList<Book> selection = SelectBooks();
        System.out.println("The books you wish to modify are the following");
        DisplayBooks(selection);
        System.out.println("");
        System.out.println("What is the variable you which to modify?");
        System.out.println("For the book ID, enter 'B'. For the work ID, enter 'W'. For the edition ID, enter 'E'. For the location, enter 'L'. "
                + "For the buy date, enter 'D'. For the isbn, enter 'I'. For the format, enter 'F'. For the language, enter 'G'.");
        option = input.nextLine();
        switch (option) {
            case "B": var="bookid";break;
            case "W": var="workid";break;
            case "E": var="editionid";break;
            case "L": var="location";break;
            case "D": var="buy_date";break;
            case "I": var="isbn";break;
            case "F": var="format";break;
            case "G": var="language";break;
            default : System.out.println("The value entered is not valid, please enter a correct one");
        }
        System.out.println("");
        System.out.println("What is the new value of this variable? ");
        val = input.nextLine();
        if (var.equals("editionid")){
            while (ManageEditions.getEditionFromQuery("editionid", val).isEmpty()) {
                System.out.println("This ID doesn't exist, please enter a valid ID");
                val = input.nextLine();
            }
        }
        if (var.equals("workid")){
            while (ManageWorks.getWorkFromQuery("workid", val).isEmpty()) {
                System.out.println("This ID doesn't exist, please enter a valid ID");
                val = input.nextLine();
            }
        }
        
        modifyBookInQuery(selection, var, val);        
    }
    
    private static void DeleteBooks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Deletion of books");
        ArrayList<Book> selection = SelectBooks();
        System.out.println("");
        System.out.println("The following books will be deleted.");
        DisplayBooks(selection);
        System.out.println("Do you confirm?");
        option=input.nextLine();
        if(option.equals("Y")) {
            for (Book a : selection ) {
                deleteBookByQuery(a);
            }
        } else {
            System.out.println("The books were not deleted");}
    }
    
    private static ArrayList<Book> SelectBooks() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        String id=new String();
        String var=new String();
        String val=new String();
        String option=new String();
        System.out.println("Selection of books");
        System.out.println("To search based on the book ID, enter 'B'");
        System.out.println("To search based on the work ID, enter 'W'");
        System.out.println("To search based on the edition ID, enter 'E'");
        System.out.println("To search based on the location, enter 'L'");
        System.out.println("To search based on the buy date, enter 'D'");
        System.out.println("To search based on the isbn, enter 'I'");
        System.out.println("To search based on the format, enter 'F'");
        System.out.println("To search based on the language, enter 'G'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "B": var="bookid";break;
            case "W": var="workid";break;
            case "E": var="editionid";break;
            case "L": var="location";break;
            case "D": var="buy_date";break;
            case "I": var="isbn";break;
            case "F": var="format";break;
            case "G": var="language";break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
        System.out.println("Please enter the value you are look for");
        val= input.nextLine();
        System.out.println("");
        return getBookFromQuery(var, val);
    }
    
    public static ArrayList<Book> getBookFromQuery(String var, String val) throws ClassNotFoundException, SQLException {
        ArrayList<Book> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM WORKS WHERE "+var+"='"+val+"'");
        while (resultSet.next()) {
            Book b = new Book();
            selection.add(b);
            b.setBookid(resultSet.getString(1));
            b.setWorkid(resultSet.getString(2));
            b.setLocation(resultSet.getString(3));
            b.setBuyDate(resultSet.getString(4));
            b.setIsbn(resultSet.getString(5));
            b.setFormat(resultSet.getString(6));
            b.setLanguage(resultSet.getString(7));
        }
        return selection;
    }
    
    public static void modifyBookInQuery(ArrayList<Book> selection, String var, String val) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        for (Book a : selection) {
            statement.execute("UPDATE WORKS SET "+var+"='"+val+"' WHERE WORKID='"+a.getBookid()+"'");
        }
    }
    
    private static void setBookToQuery(Book a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("insert into WORKS (bookid,workid,editionid,location,buy_date,isbn,format,language) values ('"+a.getBookid()+"','"+a.getWorkid()+"','"+a.getEditionid()+"','"+a.getLocation()+"','"+a.getBuyDate()+"','"+a.getIsbn()+"','"+a.getFormat()+"','"+a.getLanguage()+"') ;");
    }
    
    private static ArrayList<Book> getAllBooks() throws ClassNotFoundException, SQLException {
        ArrayList<Book> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM WORKS");
        while (resultSet.next()) {
            Book b = new Book();
            selection.add(b);
            b.setBookid(resultSet.getString(1));
            b.setWorkid(resultSet.getString(2));
            b.setLocation(resultSet.getString(3));
            b.setBuyDate(resultSet.getString(4));
            b.setIsbn(resultSet.getString(5));
            b.setFormat(resultSet.getString(6));
            b.setLanguage(resultSet.getString(7));
        }
        return selection;
    }
    
    private static void deleteBookByQuery(Book a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("DELETE FROM WORKS WHERE bookid='"+a.getBookid()+"'");
    }
    
    private static void DisplayBooks(ArrayList<Book> selection) {
        System.out.println("Book ID ; Work ID ; Edition ID ; Location ; Buy Date ; ISBN ; Format ; Language");
        for (Book b : selection) {
            b.toDisplay();
        }
        System.out.println("");
    }
    
}
