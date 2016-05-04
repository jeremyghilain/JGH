package eu.epfc.cours3449.LibraryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import eu.epfc.cours3449.LibraryDAOmodel.Author;
import eu.epfc.cours3449.LibraryDAOmodel.Edition;
import eu.epfc.cours3449.LibraryDAOmodel.Book;
import eu.epfc.cours3449.LibraryDAOmodel.Work;

public class LibraryDAOImpl implements LibraryDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    private void executeQuery(String query) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
    }

    /*
     %%%%% Queries on Authors
     */
    private ArrayList<Author> getAuthors(String query) {
        ArrayList<Author> selection = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author a = new Author();
                selection.add(a);
                a.setAuthorid(resultSet.getString(1));
                a.setName(resultSet.getString(2));
                a.setFamilyName(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
        return selection;
    }

    public ArrayList<Author> getAuthorFromQuery(String var, String val) {
        String query = "SELECT * FROM AUTHORS WHERE " + var + "='" + val + "'";
        return getAuthors(query);
    }

    public ArrayList<Author> getAllAuthors() {
        String query = "SELECT * FROM AUTHORS";
        return getAuthors(query);
    }

    public void setAuthorToQuery(Author a) {
        String query = "insert into AUTHORS (authorid,name,family_name) values ('" + a.getAuthorid() + "','" + a.getName() + "','" + a.getFamilyName() + "') ;";
        executeQuery(query);
    }

    public void deleteAuthorByQuery(Author a) {
        String query = "DELETE FROM AUTHORS WHERE authorid='" + a.getAuthorid() + "'";
        executeQuery(query);
    }

    public void modifyAuthorInQuery(ArrayList<Author> selection, String var, String val) {
        Connection connection = null;
        try {
            connection = getConnection();
            for (Author a : selection) {
                PreparedStatement statement = connection.prepareStatement("UPDATE AUTHORS SET " + var + "='" + val + "' WHERE AUTHORID='" + a.getAuthorid() + "'");
                statement.executeQuery();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
    }

    
    /*
     %%%%% Queries on Works
     */
    
    private ArrayList<Work> getWorks(String query) {
        ArrayList<Work> selection = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Work w = new Work();
                selection.add(w);
                w.setWorkid(resultSet.getString(1));
                w.setAuthorid(resultSet.getString(2));
                w.setTitle(resultSet.getString(3));
                w.setFirstPublication(resultSet.getString(4));
                w.setOrigLanguage(resultSet.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
        return selection;
    }

    public ArrayList<Work> getWorkFromQuery(String var, String val) {
        String query = "SELECT * FROM WORKS WHERE " + var + "='" + val + "'";
        return getWorks(query);
    }

    public ArrayList<Work> getAllWorks() {
        String query = "SELECT * FROM WORKS";
        return getWorks(query);
    }

    public void setWorkToQuery(Work a) {
        String query = "insert into WORKS (workid,authorid,title,first_publication,original_language) values ('" + a.getWorkid() + "','" + a.getAuthorid() + "','" + a.getTitle() + "','" + a.getFirstPublication() + "','" + a.getOrigLanguage() + "') ;";
        executeQuery(query);
    }

    public void deleteWorkByQuery(Work a) {
        String query = "DELETE FROM WORKS WHERE workid='" + a.getWorkid() + "'";
        executeQuery(query);
    }

    public void modifyWorkInQuery(ArrayList<Work> selection, String var, String val) {
        Connection connection = null;
        try {
            connection = getConnection();
            for (Work w : selection) {
                PreparedStatement statement = connection.prepareStatement("UPDATE WORKS SET " + var + "='" + val + "' WHERE WORKID='" + w.getWorkid() + "'");
                statement.executeQuery();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
    }

    
    /*
     %%%%% Queries on Books
     */
    
    
    private ArrayList<Book> getBooks(String query) {
        ArrayList<Book> selection = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            Book b = new Book();
            selection.add(b);
            b.setBookid(resultSet.getString(1));
            b.setWorkid(resultSet.getString(2));
            b.setLocation(resultSet.getString(3));
            b.setBuyDate(resultSet.getString(4));
            b.setIsbn(resultSet.getString(5));
            b.setFormat(resultSet.getString(6));
            b.setLanguage(resultSet.getString(7));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
        return selection;
    }
    
    public ArrayList<Book> getBookFromQuery(String var, String val) {
        String query = "SELECT * FROM WORKS WHERE "+var+"='"+val+"'";
        return getBooks(query);
    }
    
    private ArrayList<Book> getAllBooks() {
        String query = "SELECT * FROM WORKS";
        return getBooks(query);
    }
    
    public static void modifyBookInQuery(ArrayList<Book> selection, String var, String val) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connx = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        Statement statement = connx.createStatement();
        for (Book a : selection) {
            statement.execute("UPDATE WORKS SET "+var+"='"+val+"' WHERE WORKID='"+a.getBookid()+"'");
        }
    }
    
    private void setBookToQuery(Book a) {
        String query = "insert into WORKS (bookid,workid,editionid,location,buy_date,isbn,format,language) values ('"+a.getBookid()+"','"+a.getWorkid()+"','"+a.getEditionid()+"','"+a.getLocation()+"','"+a.getBuyDate()+"','"+a.getIsbn()+"','"+a.getFormat()+"','"+a.getLanguage()+"') ;";
        executeQuery(query);
    }
    
    private void deleteBookByQuery(Book a) {
        String query = "DELETE FROM WORKS WHERE bookid='"+a.getBookid()+"'";
        executeQuery(query);
    }
    
    
}
