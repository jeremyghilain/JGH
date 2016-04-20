package eu.epfc.cours3449.DAO;

import java.util.List;
import eu.epfc.cours3449.DAOmodel.Book;
import eu.epfc.cours3449.DAOmodel.Category;

public interface BookDAO {

    public List<Book> findAllBooks();

    public List<Book> searchBooksByKeyword(String keyWord);

    public List<Category> findAllCategories();

    public void insert(Book book);

    public void update(Book book);

    public void delete(Long bookId);
}
