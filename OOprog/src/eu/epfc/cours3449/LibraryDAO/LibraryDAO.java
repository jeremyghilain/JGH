package eu.epfc.cours3449.LibraryDAO;

import java.util.ArrayList;
import java.util.List;
import eu.epfc.cours3449.LibraryDAOmodel.Author;
import eu.epfc.cours3449.LibraryDAOmodel.Edition;
import eu.epfc.cours3449.LibraryDAOmodel.Book;
import eu.epfc.cours3449.LibraryDAOmodel.Work;

public interface LibraryDAO {

    public ArrayList<Author> getAuthorFromQuery(String var, String val);

    public ArrayList<Author> getAllAuthors();

    public void setAuthorToQuery(Author a);

    public void deleteAuthorByQuery(Author a);

    public void modifyAuthorInQuery(ArrayList<Author> selection, String var, String val);

    public ArrayList<Work> getWorkFromQuery(String var, String val);

    public ArrayList<Work> getAllWorks();

    public void setWorkToQuery(Work w);

    public void deleteWorkByQuery(Work w);

    public void modifyWorkInQuery(ArrayList<Work> selection, String var, String val);

    public ArrayList<Book> getBookFromQuery(String var, String val);

    public ArrayList<Book> getAllBooks();

    public void modifyBookInQuery(ArrayList<Book> selection, String var, String val);

    public void setBookToQuery(Book a);

    public void deleteBookByQuery(Book a);

    public ArrayList<Edition> getEditionFromQuery(String var, String val);

    public ArrayList<Edition> getAllEditions();

    public void modifyEditionInQuery(ArrayList<Edition> selection, String var, String val);

    public void setEditionToQuery(Edition a);

    public void deleteEditionByQuery(Edition a);
}
