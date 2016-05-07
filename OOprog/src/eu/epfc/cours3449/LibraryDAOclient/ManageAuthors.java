
package eu.epfc.cours3449.LibraryDAOclient;

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
import eu.epfc.cours3449.LibraryDAO.LibraryDAO;
import eu.epfc.cours3449.LibraryDAO.LibraryDAOImpl;
import eu.epfc.cours3449.LibraryDAOmodel.Author;
import eu.epfc.cours3449.LibraryDAOmodel.Work;
import eu.epfc.cours3449.LibraryDAOmodel.Book;

public class ManageAuthors {
    private static LibraryDAO libraryDAO = new LibraryDAOImpl();
//le static permet d'avoir la variable de manière globale, quelque soit la méthode
    
    public static void main(String args[ ]) throws ClassNotFoundException, SQLException {
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
            case "A": DisplayAuthors(libraryDAO.getAllAuthors()); break;
            case "S": DisplayAuthors(SelectAuthors()); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    public static void AddAuthors() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String val=new String();
        System.out.println("Addition of authors");
        Author a=new Author();
        System.out.println("Please enter the ID of the new author");
        val = input.nextLine();
        while (!libraryDAO.getAuthorFromQuery("authorid", val).isEmpty()) {
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
        libraryDAO.setAuthorToQuery(a);
    }
    
    private static void ModifyAuthors() throws ClassNotFoundException, SQLException{        
        Scanner input = new Scanner(System.in);
        String option=new String();
        String var=new String();
        String val=new String();
        String oldval=new String();
        System.out.println("Modification of authors");        
        System.out.println("What is the author you which to modify");
        ArrayList<Author> selection = SelectAuthors();
        System.out.println("The authors you wish to modify are the following");
        DisplayAuthors(selection);
        System.out.println("");
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
        oldval=selection.get(0).getAuthorid();
        
        libraryDAO.modifyAuthorInQuery(selection, var, val);
        if (var.equals("authorid")) {
            libraryDAO.modifyWorkInQuery(libraryDAO.getWorkFromQuery(var, oldval), var, val);
            libraryDAO.modifyBookInQuery(libraryDAO.getBookFromQuery(var, oldval), var, val);
        }
    }
    
    private static void DeleteAuthors() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Deletion of authors");
        ArrayList<Author> selection = SelectAuthors();
        String oldval=selection.get(0).getAuthorid();
        ArrayList<Work> workselect =libraryDAO.getWorkFromQuery("workid", oldval);
        ArrayList<Book> bookselect =libraryDAO.getBookFromQuery("bookid", oldval);
        System.out.println("");
        System.out.println("The following authors will be deleted.");
        DisplayAuthors(selection);
        System.out.println("Do you confirm?");
        option=input.nextLine();
        if(option.equals("Y")) {
            for (Author a : selection ) {
                libraryDAO.deleteAuthorByQuery(a);                                
            }
            System.out.println("");
            System.out.println("The deleted authors were the authors of the following works. Do you confirm their deletion?");
            ManageWorks.DisplayWorks(workselect);
            option=input.nextLine();
            if(option.equals("Y")) {
                for (Work w : workselect) {
                    libraryDAO.deleteWorkByQuery(w);
                }
            }
            System.out.println("");
            System.out.println("The deleted authors were the authors of the following books. Do you confirm their deletion?");
            ManageBooks.DisplayBooks(bookselect);
            option=input.nextLine();
            if(option.equals("Y")) {
                for (Book b : bookselect) {
                    libraryDAO.deleteBookByQuery(b);
                }
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
        return libraryDAO.getAuthorFromQuery(var, val);
    }
    
    
    
    private static void DisplayAuthors(ArrayList<Author> selection) {
        System.out.println("Author ID ; Name ; Family name");
        for (Author a : selection) {
            a.toDisplay();
        }
        System.out.println("");
    }
}
