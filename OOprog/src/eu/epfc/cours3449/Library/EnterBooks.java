package eu.epfc.cours3449.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class EnterBooks {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Books.csv";
        Boolean cont = true;
        String option = new String();
        Scanner input = new Scanner(System.in);
        Scanner filein = new Scanner(new File(fileName));
        ArrayList<Book> collection = new ArrayList<>();

        FillBooksFromFile(filein, collection, fileName);

        while (cont) {
            cont = ManageBooksMenu(input, collection, cont);
        }

        DisplayBookBasics(collection);

        WriteCSV(collection, fileName);
        //WriteTXT(collection, "Books.txt", option);
    }

    private static Boolean ManageBooksMenu(Scanner input, ArrayList<Book> collection, Boolean cont) {
        String option;
        System.out.println("If you want to enter more books manualy, type A");
        System.out.println("If you want to view a book, type S");
        System.out.println("If you want to modify a book, type M");
        System.out.println("If you want to delete books from the list, type D");
        System.out.println("If you want to quit, type Q");
        option = input.nextLine();
        switch (option) {
            case "A":
                ManualyFillBooks(option, input, collection);
                break;
            case "S":
                break;
            case "M":
                break;
            case "D":
                break;
            case "Q":
                cont = false;
                break;
            default:
                System.out.println("The value enterred in not valid");
                break;
        }
        return cont;
    }

    private static void FillBooksFromFile(Scanner filein, ArrayList<Book> collection, String fileName) {
        System.out.println("The list of books is based on the source file " + fileName + ".");
        String[] infile = new String[12];
        String header = new String();
        header = filein.nextLine();
        while (filein.hasNext()) {
            infile = filein.nextLine().split(";");
            Book b = new Book();
            Edition e = new Edition();
            Author a = new Author();
            collection.add(b);
            b.setAuthor(a);
            b.setEdition(e);
            // read the file's columns
            b.setIdentifier(infile[0]);
            b.setLocation(infile[1]);
            b.setBuyDate(infile[2]);
            e.setName(infile[3]);
            b.setIsbn(infile[4]);
            b.setFormat(infile[5]);
            b.setLanguage(infile[6]);
            a.setName(infile[7]);
            a.setFamilyName(infile[8]);
            b.setTitle(infile[9]);
            b.setFirstPublication(infile[10]);
            b.setOrigLanguage(infile[11]);
        }
    }

    private static void ManualyFillBooks(String option, Scanner input, ArrayList<Book> collection) {
        System.out.println("To enter new books, chose the quantity of information you wish to enter");
        System.out.println("To enter only the basics, enter 'B'.");
        System.out.println("To enter a longer description, enter 'L'.");
        System.out.println("To enter the full description, enter 'F'.");
        option = input.nextLine();
        while (true) {
            Book b = new Book();
            collection.add(b);

            switch (option) {
                case "B":
                    EnterBookBasics(b, input);
                    break;
                case "L":
                    EnterBookBasics(b, input);
                    EnterBookLong(b, input);
                    break;
                case "F":
                    EnterBookBasics(b, input);
                    EnterBookLong(b, input);
                    EnterWork(b, input);
                    break;
            }

            System.out.println("Do you want to enter a new book? (N to quit)");
            if (input.nextLine().equals("N")) {
                break;
            }

        }
    }

    private static void WriteCSV(ArrayList<Book> collection, String csvName) throws FileNotFoundException {
        PrintWriter csv = new PrintWriter(csvName);
        csv.println("Identifier;Location;Buy Date;Edition;Isbn;Format;Language;Author Name;Author Family Name;Title;First Pub;Orig Lang");
        for (int i = 0; i < collection.size(); i++) {
            csv.println(collection.get(i).toCsv());
        }
        csv.close();
    }

    private static void EnterBookBasics(Book b, Scanner input) {
        System.out.println("Please enter the identifier of the book :");
        b.setIdentifier(input.nextLine());

        System.out.println("Please enter the location where the book will be stored:");
        b.setLocation(input.nextLine());

        System.out.println("Please enter the buy date of the book :");
        b.setBuyDate(input.nextLine());

    }

    private static void EnterBookLong(Book b, Scanner input) {
        Edition e = new Edition();
        System.out.println("Please enter the edition of the book :");
        e.setName(input.nextLine());
        b.setEdition(e);

        System.out.println("Please enter the ISBN of the book:");
        b.setIsbn(input.nextLine());

        System.out.println("Please enter the format of the book :");
        b.setFormat(input.nextLine());

        System.out.println("Please enter the language of the book :");
        b.setLanguage(input.nextLine());

    }

    private static void EnterWork(Book b, Scanner input) {
        Author a = new Author();
        System.out.println("Please enter the name author of the book :");
        a.setName(input.nextLine());
        System.out.println("Please enter the family name author of the book :");
        a.setFamilyName(input.nextLine());
        b.setAuthor(a);

        System.out.println("Please enter the title of the book:");
        b.setTitle(input.nextLine());

        System.out.println("Please enter the date of the first publication of the book :");
        b.setFirstPublication(input.nextLine());

        System.out.println("Please enter the original language of the book :");
        b.setOrigLanguage(input.nextLine());

    }

    private static void DisplayBookBasics(ArrayList<Book> collection) {
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i).getIdentifier() + " " + collection.get(i).getLocation() + " " + collection.get(i).getBuyDate());
        }
    }

    private static void WriteTXT(ArrayList<Book> collection, String fileName, String option) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        for (int i = 0; i < collection.size(); i++) {
            switch (option) {
                case "B":
                    out.println(collection.get(i).toString());
                    break;
                default:
                    out.println(collection.get(i).toStringLong());
                    break;
            }
        }
        out.close();
    }

}
