package eu.epfc.cours3449.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class ManageBooks {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Books.csv";
        Boolean cont = true;
        Scanner input = new Scanner(System.in);

        System.out.println("The list of books is based on the source file " + fileName + ".");
        
        while (cont) {
            cont = ManageBooksMenu(input, cont, fileName);
        }
        

        /*

        Careful! the techid is modified by the selection array, 
        as there are new books created there as well
        
        Issue when trying to select per Author family name
        
        
        No management of errors, no try-catch
        
        no "deep clone" of books (security issue)
        
        
        
        */
        
        
        
        
    }

    private static ArrayList<Book> FillBooksFromFile(String fileName) throws FileNotFoundException {
        Scanner filein = new Scanner(new File(fileName));
        ArrayList<Book> collection = new ArrayList<>();
        String[] infile = new String[13];
        filein.nextLine();
        while (filein.hasNext()) {
            infile = filein.nextLine().split(";");
            Book b = new Book("null");
            Edition e = new Edition();
            Author a = new Author();
            collection.add(b);
            b.setAuthor(a);
            b.setEdition(e);
            // read the file's columns
            b.setIdentifier(infile[1]);
            b.setLocation(infile[2]);
            b.setBuyDate(infile[3]);
            e.setName(infile[4]);
            b.setIsbn(infile[5]);
            b.setFormat(infile[6]);
            b.setLanguage(infile[7]);
            a.setName(infile[8]);
            a.setFamilyName(infile[9]);
            b.setTitle(infile[10]);
            b.setFirstPublication(infile[11]);
            b.setOrigLanguage(infile[12]);
        }
        return collection;
    }

    private static Boolean ManageBooksMenu(Scanner input, Boolean cont, String fileName) throws FileNotFoundException {
        String option = new String();
        System.out.println("");
        System.out.println("To get a display of all the book, press 'All'");
        System.out.println("If you want to enter more books manualy, type A");
        System.out.println("If you want to view a book, type S");
        System.out.println("If you want to modify a book, type M");
        System.out.println("If you want to delete books from the list, type D");
        System.out.println("If you want to quit, type Q");
        option = input.nextLine();
        switch (option) {
            case "All":
                DisplayBooksComplete(FillBooksFromFile(fileName));
                break;
            case "A":
                ManualyFillBooks(input, fileName);
                break;
            case "S":
                DisplayBooksComplete(SelectionOfBooks(input, fileName));
                //SummaryOfBooks(input, collection);
                break;
            case "M":
                ModifyBook(input, fileName);
                break;
            case "D":
                DeleteBook(input, fileName);
                break;
            case "Q":
                cont = false;
                System.out.println("The final contents of the file "+fileName+" are :");
                DisplayBooksComplete(FillBooksFromFile(fileName));
                System.out.println("");
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("The value enterred in not valid. Try again.");
                break;
        }
        return cont;
    }

    private static void ManualyFillBooks(Scanner input, String fileName) throws FileNotFoundException {
        System.out.println("To enter new books, chose the quantity of information you wish to enter");
        System.out.println("To enter only the basics, enter 'B'.");
        System.out.println("To enter a longer description, enter 'L'.");
        System.out.println("To enter the full description, enter 'F'.");
        ArrayList<Book> collection=FillBooksFromFile(fileName);
        String option = new String();
        option = input.nextLine();
        while (true) {
            Book b = new Book("null");
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
        WriteCSV(collection, fileName);
    }

    private static void ModifyBook(Scanner input, String fileName) throws FileNotFoundException {
        String option = new String();
        String newval = new String();
        Boolean cont = true;
        ArrayList<Book> collection=FillBooksFromFile(fileName);
        ArrayList<Book> selection = new ArrayList<>();
        System.out.println("If there are more than one book selected, you will have to select again");
        while (selection.size() != 1) {
            selection=SelectionOfBooks(input, fileName);
        }

        while (cont) {
            System.out.println("");
            System.out.println("Enter the name of the variable you want to modify among : ");
            System.out.println("identifier, location, buy date, edition, isbn, format,");
            System.out.println("language, author name, author family name, title, ");
            System.out.println("first publication, original language");
            System.out.println("");
            System.out.println("To get back to the previous menu, press 'R'");
            option = input.nextLine();
            if (option.equals("R")){
                cont = false;
                System.out.println("");
            } else {
                System.out.println("Enter the new value for the variable " + option + " :");
                newval = input.nextLine();
                collection.removeAll(selection);
                selection.get(0).modBookVar(option,newval);
                collection.add(selection.get(0));
            }
        }
        WriteCSV(collection, fileName);
    }

    private static void DeleteBook(Scanner input, String fileName) throws FileNotFoundException {
        ArrayList<Book> collection=FillBooksFromFile(fileName);
        ArrayList<Book> selection =SelectionOfBooks(input, fileName);
        System.out.println("Please confirm the deletion of the following books (Y/N)");
        DisplayBooksComplete(selection);
        System.out.println("");
        String in = input.nextLine();
        if (in.equals("Y")) {
            collection.removeAll(selection);
            System.out.println("The books have been removed");
        } else {
            System.out.println("The books were not removed");
        }
        WriteCSV(collection, fileName);
    }
    
    private static ArrayList<Book> SelectionOfBooks(Scanner input, String fileName) throws FileNotFoundException {
        ArrayList<Book> selection = new ArrayList<>();
        String option = new String();
        while (selection.isEmpty()) {
            System.out.println("");
            System.out.println("The selection is empty, please select something");
            System.out.println("To select books according to the identifier, press 'I'");
            System.out.println("To select books according to the title, press 'T'");
            System.out.println("To select books according to the author, press 'A'");
            option = input.nextLine();
            switch (option) {
                case "I":
                    selection = SelectBooksPerIdentifier(input, FillBooksFromFile(fileName));
                    break;
                case "T":
                    selection = SelectBooksPerTitle(input, FillBooksFromFile(fileName));
                    break;
                case "A":
                    selection = SelectBooksPerAuthor(input, FillBooksFromFile(fileName));
                    break;
                default:
                    System.out.println("The value enterred in not valid. Try again.");
                    break;
            }
        }
        return selection;
    }

    private static ArrayList<Book> SelectBooksPerIdentifier(Scanner input, ArrayList<Book> collection) {
        ArrayList<Book> selection = new ArrayList<>();
        String in;
        System.out.println("Please enter the identifier of the book you are looking for:");
        in = input.nextLine();
        for (Book b : collection) {
            if (b.getIdentifier().equals(in)) {
                selection.add(b);
            }
        }
        return selection;
    }

    private static ArrayList<Book> SelectBooksPerTitle(Scanner input, ArrayList<Book> collection) {
        ArrayList<Book> selection = new ArrayList<>();
        String in;
        System.out.println("Please enter the title of the book you are looking for:");
        in = input.nextLine();
        for (Book b : collection) {
            if (b.getTitle().equals(in)) {
                selection.add(b);
            }
        }
        return selection;
    }

    private static ArrayList<Book> SelectBooksPerAuthor(Scanner input, ArrayList<Book> collection) {
        ArrayList<Book> selection = new ArrayList<>();
        String in;
        System.out.println("Please enter the Family Name of the book you are looking for:");
        in = input.nextLine();
        for (Book b : collection) {
            Author a = new Author();
            b.setAuthor(a);
            if (a.getFamilyName().equals(in)) {
                selection.add(b);
            }
        }
        return selection;
    }

    private static void WriteCSV(ArrayList<Book> collection, String csvName) throws FileNotFoundException {
        PrintWriter csv = new PrintWriter(csvName);
        csv.println("Tech ID;Identifier;Location;Buy Date;Edition;Isbn;Format;Language;Author Name;Author Family Name;Title;First Pub;Orig Lang");
        for (Book b : collection) {
            csv.println(b.toCsv());
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

    private static void DisplayBooksBasics(ArrayList<Book> collection) {
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i).getIdentifier() + " " + collection.get(i).getLocation() + " " + collection.get(i).getBuyDate());
        }
    }

    private static void DisplayBooksComplete(ArrayList<Book> collection) {
        for (Book b : collection) {
            b.toDisplay();
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

    /*
    private static void SummaryOfBooks(Scanner input, ArrayList<Book> collection) {
        DisplayBooksComplete(SelectionOfBooks(input, collection));
    }
    */
    
}
