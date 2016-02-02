package eu.epfc.cours3449.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class EnterBooks {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Newbooks.txt";
        String csvName = "Books.csv";
        String option = new String();
        Scanner input = new Scanner(System.in);
        Scanner fin = new Scanner(new File (fileName));
        ArrayList<Book> collection = new ArrayList<>();
        
        
        FillBooksFromFile(fin, collection);
        

        System.out.println("The list of books will be based on the source file " +fileName+".");
        System.out.println("Do you want to enter more books manualy? (Y/N)");
        option = input.nextLine();
        if (option.equals("Y")) {
            ManualyFillBooks(option, input, collection);
        }

        DisplayBookBasics(collection);

        WriteTXT(collection, "Books.txt", option);

        WriteCSV(collection, csvName);

    }

    private static void FillBooksFromFile(Scanner fin, ArrayList<Book> collection) {
        String[] infile = new String[12];
        while(fin.hasNext()) {
            infile = fin.nextLine().split(";");
            Book b = new Book();
            collection.add(b);
            b.setIdentifier(infile[0]);
            b.setLocation(infile[1]);
            b.setBuyDate(infile[2]);
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

    private static void WriteCSV(ArrayList<Book> collection, String csvName) throws FileNotFoundException {
        PrintWriter csv = new PrintWriter(csvName);
        csv.println("identifier;location;buyDate;edition;isbn;format;language");
        for (int i = 0; i < collection.size(); i++) {
            csv.println(collection.get(i).toCsv());
        }
        csv.close();
    }

    private static void DisplayBookBasics(ArrayList<Book> collection) {
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i).getIdentifier() + " " + collection.get(i).getLocation() + " " + collection.get(i).getBuyDate());
        }
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

}
