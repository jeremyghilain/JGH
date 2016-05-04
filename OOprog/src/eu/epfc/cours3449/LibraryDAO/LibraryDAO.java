package eu.epfc.cours3449.LibraryDAO;

import java.util.ArrayList;
import java.util.List;
import eu.epfc.cours3449.LibraryDAOmodel.Author;
import eu.epfc.cours3449.LibraryDAOmodel.Edition;
import eu.epfc.cours3449.LibraryDAOmodel.Book;
import eu.epfc.cours3449.LibraryDAOmodel.Work;

public interface LibraryDAO {
    
    public ArrayList<Author> getAuthorFromQuery(String var, String val) ;

    public ArrayList<Author> getAllAuthors() ;
    
    public void setAuthorToQuery(Author a);

    public void deleteAuthorByQuery(Author a);
    
    public void modifyAuthorInQuery(ArrayList<Author> selection, String var, String val);

    public ArrayList<Work> getWorkFromQuery(String var, String val) ;

    public ArrayList<Work> getAllWorks() ;
    
    public void setWorkToQuery(Work w);

    public void deleteWorkByQuery(Work w);
    
    public void modifyWorkInQuery(ArrayList<Work> selection, String var, String val);
    
        public ArrayList<Book> getBookFromQuery(String var, String val);
    
    private ArrayList<Book> getAllBooks();
    
    public static void modifyBookInQuery(ArrayList<Book> selection, String var, String val);
    
    private void setBookToQuery(Book a);
    
    private void deleteBookByQuery(Book a);
    
}
