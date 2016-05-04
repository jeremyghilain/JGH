
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

public class ManageWorks {
    private static LibraryDAO libraryDAO = new LibraryDAOImpl();
//le static permet d'avoir la variable de manière globale, quelque soit la méthode    public static void main(String args[ ]) throws ClassNotFoundException, SQLException {
    
    public static void main(String args[ ]) throws ClassNotFoundException, SQLException {
        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        while (cont) {
            System.out.println("Management of works");
            System.out.println("To display works, enter 'S'");
            System.out.println("To add works, enter 'A'");
            System.out.println("To modify works, enter 'M'");
            System.out.println("To delete works, enter 'D'");
            System.out.println("To quit this menu, enter 'Q'");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "S": SummaryWorks(); break;
                case "A": AddWorks(); break;
                case "M": ModifyWorks(); break;
                case "D": DeleteWorks(); break;
                case "Q": cont=false; break;
                default : System.out.println("The value entered is not valid, please enter a correct one");
            }
        }
        
        
        
    }
    
    private static void SummaryWorks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Summary of Works");
        System.out.println("To display all works, enter 'A'");
        System.out.println("To select an specific work, enter 'S'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "A": DisplayWorks(getAllWorks()); break;
            case "S": DisplayWorks(SelectWorks()); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    private static void AddWorks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String val=new String();
        String opt=new String();
        System.out.println("Addition of works");
        Work a=new Work();
        System.out.println("Please enter the ID of the new work");
        val = input.nextLine();
        while (!getWorkFromQuery("workid", val).isEmpty()) {
            System.out.println("This ID is already used, please enter a valid ID");
            val = input.nextLine();
        }
        a.setWorkid(val);
        System.out.println("Is the author of this work a new author? (Y/N)");
        opt = input.nextLine();
        if (opt.equals("Y")) {
            ManageAuthors.AddAuthors();
        }
        System.out.println(" ");
        System.out.println("Please enter the ID of the author of the work");
        val = input.nextLine();
        while (ManageAuthors.getAuthorFromQuery("authorid", val).isEmpty()) {
            System.out.println("This ID doesn't exist, please enter a valid ID");
            val = input.nextLine();
        }
        a.setAuthorid(val);
        
        System.out.println("");
        System.out.println("Please enter the title of the work");
        a.setTitle(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the date of first publication of the work");
        a.setFirstPublication(input.nextLine());
        System.out.println("");
        System.out.println("Please enter the original language of the work");
        a.setOrigLanguage(input.nextLine());
        System.out.println("");
        System.out.println("The new work is:");
        a.toDisplay();
        setWorkToQuery(a);
    }
    
    private static void ModifyWorks() throws ClassNotFoundException, SQLException{        
        Scanner input = new Scanner(System.in);
        String option=new String();
        String var=new String();
        String val=new String();
        System.out.println("Modification of works");        
        System.out.println("What is the work you which to modify");
        ArrayList<Work> selection = SelectWorks();
        System.out.println("The works you wish to modify are the following");
        DisplayWorks(selection);
        System.out.println("");
        System.out.println("What is the variable you which to modify?");
        System.out.println("For the ID, enter 'I'. For the author ID, enter 'A'. For the title, enter 'T'. "
                + "For the date of first publication, enter 'P'. For the original language, enter 'L'");
        option = input.nextLine();
        switch (option) {
            case "I": var="workid";break;
            case "A": var="authorid";break;
            case "T": var="title";break;
            case "P": var="first_publication";break;
            case "L": var="original_language";break;
            default : System.out.println("The value entered is not valid, please enter a correct one");
        }
        System.out.println("");
        System.out.println("What is the new value of this variable? ");
        val = input.nextLine();
        if (var.equals("authorid")){
            while (ManageAuthors.getAuthorFromQuery("authorid", val).isEmpty()) {
                System.out.println("This ID doesn't exist, please enter a valid ID");
                val = input.nextLine();
            }
        }
        
        modifyWorkInQuery(selection, var, val);        
    }
    
    private static void DeleteWorks() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Deletion of works");
        ArrayList<Work> selection = SelectWorks();
        System.out.println("");
        System.out.println("The following works will be deleted.");
        DisplayWorks(selection);
        System.out.println("Do you confirm?");
        option=input.nextLine();
        if(option.equals("Y")) {
            for (Work a : selection ) {
                deleteWorkByQuery(a);
            }
        } else {
            System.out.println("The works were not deleted");}
    }
    
    private static ArrayList<Work> SelectWorks() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        String id=new String();
        String var=new String();
        String val=new String();
        String option=new String();
        System.out.println("Selection of works");
        System.out.println("To search based on the ID, enter 'I'");
        System.out.println("To search based on the author ID, enter 'A'");
        System.out.println("To search based on the title, enter 'T'");
        System.out.println("To search based on the date of first publication, enter 'P'");
        System.out.println("To search based on the original language, enter 'L'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "I": var="workid";break;
            case "A": var="authorid";break;
            case "T": var="title";break;
            case "P": var="first_publication";break;
            case "L": var="original_language";break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
        System.out.println("Please enter the value you are look for");
        val= input.nextLine();
        System.out.println("");
        return getWorkFromQuery(var, val);
    }
    
    public static void DisplayWorks(ArrayList<Work> selection) {
        System.out.println("Work ID ; Author ID ; Title ; First Publication ; Original Language");
        for (Work w : selection) {
            w.toDisplay();
        }
        System.out.println("");
    }
}
