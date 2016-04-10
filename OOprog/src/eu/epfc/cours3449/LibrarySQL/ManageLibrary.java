
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
import eu.epfc.cours3449.LibrarySQL.*;

public class ManageLibrary {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        while (cont) {
            System.out.println("Management of Library");
            System.out.println("To manage authors, enter 'A'");
            System.out.println("To manage editions, enter 'E'");
            System.out.println("To manage works, enter 'W'");
            System.out.println("To manage books, enter 'B'");
            System.out.println("To quit this menu, enter 'Q'");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "A": ManageAuthors.main();break;
                case "E": ManageEditions.main(); break;
                case "W": ManageWorks.main(); break;
                //case "B": ManageBooks(); break;
                case "Q": cont=false; break;
                default : System.out.println("The value entered is not valid, please enter a correct one");
            }
        }
    }
        
        
}