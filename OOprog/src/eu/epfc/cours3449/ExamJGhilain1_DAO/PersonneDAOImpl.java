package eu.epfc.cours3449.ExamJGhilain1_DAO;

import eu.epfc.cours3449.ExamJGhilain1_DAO.PersonneDAO;
import eu.epfc.cours3449.ExamJGhilain1_Model.Personne;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAOImpl implements PersonneDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/personnes", "root", "");
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
            Statement statement = connection.createStatement();
            int row=statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
    }    

    public ArrayList<Personne> getAllPersonnes() {
        ArrayList<Personne> selection = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSONNE");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Personne p = new Personne();
                selection.add(p);
                p.setNom(resultSet.getString(1));
                p.setPrenom(resultSet.getString(2));
                p.setAge(resultSet.getString(3));
                p.setTelephone(resultSet.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            closeConnection(connection);
        }
        return selection;
    }

    public void setPersonneToDB(Personne p) {
        String query="insert into PERSONNE (nom,prenom,age,telephone) values ('" + p.getNom() + "','" + p.getPrenom() + "','" + p.getAge() + "','" + p.getTelephone() + "') ;";
        System.out.println(query);        
        executeQuery(query);
    }


}
