
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

public class ManageEditions {
    public static void main(String args[ ]) throws ClassNotFoundException, SQLException {
        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        while (cont) {
            System.out.println("Management of editions");
            System.out.println("To display editions, enter 'S'");
            System.out.println("To add editions, enter 'A'");
            System.out.println("To modify editions, enter 'M'");
            System.out.println("To delete editions, enter 'D'");
            System.out.println("To quit this menu, enter 'Q'");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "S": SummaryEditions(); break;
                case "A": AddEditions(); break;
                case "M": ModifyEditions(); break;
                case "D": DeleteEditions(); break;
                case "Q": cont=false; break;
                default : System.out.println("The value entered is not valid, please enter a correct one");
            }
        }
        
        
        
    }
    
    private static void SummaryEditions() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Summary of Editions");
        System.out.println("To display all editions, enter 'A'");
        System.out.println("To select an specific edition, enter 'S'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "A": DisplayEditions(getAllEditions()); break;
            case "S": DisplayEditions(SelectEditions()); break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
    }
     
    public static void AddEditions() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String val=new String();
        System.out.println("Addition of editions");
        Edition e=new Edition();
        System.out.println("Please enter the ID of the new edition");
        val = input.nextLine();
        while (!getEditionFromQuery("editionid", val).isEmpty()) {
            System.out.println("This ID is already used, please enter a valid ID");
            val = input.nextLine();
        }
        e.setEditionid(val);        
        System.out.println("");
        System.out.println("Please enter the name of the new edition");
        e.setName(input.nextLine());
        System.out.println("");
        System.out.println("The new edition is:");
        e.toDisplay();
        setEditionToQuery(e);
    }
    
    private static void ModifyEditions() throws ClassNotFoundException, SQLException{        
        Scanner input = new Scanner(System.in);
        String option=new String();
        String var=new String();
        String val=new String();
        String oldval=new String();
        System.out.println("Modification of editions");        
        System.out.println("What is the edition you which to modify");
        ArrayList<Edition> selection = SelectEditions();
        System.out.println("The editions you wish to modify are the following");
        DisplayEditions(selection);
        System.out.println("");
        System.out.println("What is the variable you which to modify?");
        System.out.println("For the ID, enter 'I'. For the name, enter 'N'.");
        option = input.nextLine();
        switch (option) {
            case "I": var="editionid";break;
            case "N": var="name";break;
            default : System.out.println("The value entered is not valid, please enter a correct one");
        }
        System.out.println("");
        System.out.println("What is the new value of this variable? ");
        val = input.nextLine();
        oldval=selection.get(0).getEditionid();
        
        modifyEditionInQuery(selection, var, val);
        if (var.equals("editionid")) {
            ManageBooks.modifyBookInQuery(ManageBooks.getBookFromQuery(var, oldval), var, val);
        }
    }
    
    private static void DeleteEditions() throws ClassNotFoundException, SQLException{
        Scanner input = new Scanner(System.in);
        String option=new String();
        System.out.println("Deletion of editions");
        ArrayList<Edition> selection = SelectEditions();
        System.out.println("");
        System.out.println("The following editions will be deleted.");
        DisplayEditions(selection);
        System.out.println("Do you confirm?");
        option=input.nextLine();
        if(option.equals("Y")) {
            for (Edition e : selection ) {
                deleteEditionByQuery(e);
            }
        } else {
            System.out.println("The editions were not deleted");}
    }
    
    private static ArrayList<Edition> SelectEditions() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        String id=new String();
        String var=new String();
        String val=new String();
        String option=new String();
        System.out.println("Selection of editions");
        System.out.println("To search based on the ID, enter 'I'");
        System.out.println("To search based on the name, enter 'N'");
        System.out.println("To quit this menu, enter 'Q'");
        option = input.nextLine();
        System.out.println("");
        switch (option) {
            case "I": var="editionid";break;
            case "N": var="name";break;
            case "Q": break;
            default : System.out.println("The value entered is not valid, please enter a correct one");;
        }
        System.out.println("Please enter the value you are look for");
        val= input.nextLine();
        System.out.println("");
        return getEditionFromQuery(var, val);
    }
    
    public static ArrayList<Edition> getEditionFromQuery(String var, String val) throws ClassNotFoundException, SQLException {
        ArrayList<Edition> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EDITIONS WHERE "+var+"='"+val+"'");
        while (resultSet.next()) {
            Edition e = new Edition();
            selection.add(e);
            e.setEditionid(resultSet.getString(1));
            e.setName(resultSet.getString(2));
        }
        return selection;
    }
    
    private static void modifyEditionInQuery(ArrayList<Edition> selection, String var, String val) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        for (Edition a : selection) {
            statement.execute("UPDATE EDITIONS SET "+var+"='"+val+"' WHERE EDITIONID='"+a.getEditionid()+"'");
        }
    }
    
    private static void setEditionToQuery(Edition a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("insert into EDITIONS (editionid,name) values ('"+a.getEditionid()+"','"+a.getName()+"') ;");
    }
    
    private static ArrayList<Edition> getAllEditions() throws ClassNotFoundException, SQLException {
        ArrayList<Edition> selection = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EDITIONS");
        while (resultSet.next()) {
            Edition e = new Edition();
            selection.add(e);
            e.setEditionid(resultSet.getString(1));
            e.setName(resultSet.getString(2));
        }
        return selection;
    }
    
    private static void deleteEditionByQuery(Edition a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        statement.execute("DELETE FROM EDITIONS WHERE editionid='"+a.getEditionid()+"'");
    }
    
    private static void DisplayEditions(ArrayList<Edition> selection) {
        System.out.println("Edition ID ; Name");
        for (Edition e : selection) {
            e.toDisplay();
        }
        System.out.println("");
    }
}
