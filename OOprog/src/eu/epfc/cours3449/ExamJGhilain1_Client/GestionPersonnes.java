package eu.epfc.cours3449.ExamJGhilain1_Client;

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
import eu.epfc.cours3449.ExamJGhilain1_DAO.PersonneDAO;
import eu.epfc.cours3449.ExamJGhilain1_DAO.PersonneDAOImpl;
import eu.epfc.cours3449.ExamJGhilain1_Model.Personne;

public class GestionPersonnes {
    private static PersonneDAO personneDAO = new PersonneDAOImpl();
    
    
    public static void main(String[] args) {
        Boolean cont = true;
        String option=new String();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Gestion d'une liste de Contacts");
        while (cont) {            
            System.out.println("1 : Afficher les contacts ");
            System.out.println("2 : Insérer un contact ");
            System.out.println("3 : Quitter");
            option = input.nextLine();
            System.out.println("");
            switch (option) {
                case "1": ListePersonnes(); break;
                case "2": AjouterPersonne(); break;
                case "3": cont=false; break;
                default : System.out.println("La valeur introduite n'est pas valide, veuillez introduire une valeur correcte");
            }
        }
    }

    private static void ListePersonnes() {
        Scanner input = new Scanner(System.in);
        String format = "%-15s %-15s  %-5s %-15s \n";
        System.out.printf(format,"Nom","Prenom","Age","Telephone");
        //System.out.println("Nom \t\tPrenom \tAge \tTelephone");
        ArrayList<Personne> selection = personneDAO.getAllPersonnes();
        for (Personne p : selection) {
            p.toDisplay();
        }
        System.out.println("");
        System.out.println("Tapez return pour continuer.");
        Boolean cont = true;
        while (cont) {
            String option=input.nextLine();
            if(option.isEmpty()) {
                cont=false;
            }
        }
    }

    private static void AjouterPersonne() {
        Scanner input = new Scanner(System.in);
        String val=new String();
        Personne p=new Personne();
        System.out.println("Nom : ");
        val = input.nextLine();
        p.setNom(val);
        System.out.println("Prenom : ");
        val = input.nextLine();
        p.setPrenom(val);
        System.out.println("Age : ");
        val = input.nextLine();
        p.setAge(val);
        System.out.println("Telephone : ");
        val = input.nextLine();
        p.setTelephone(val);
        personneDAO.setPersonneToDB(p);
    }
    
}
