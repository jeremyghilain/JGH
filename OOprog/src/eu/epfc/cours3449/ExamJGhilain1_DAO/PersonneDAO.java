

package eu.epfc.cours3449.ExamJGhilain1_DAO;
import eu.epfc.cours3449.ExamJGhilain1_Model.Personne;
import java.util.ArrayList;
import java.util.List;

public interface PersonneDAO {

    public ArrayList<Personne> getAllPersonnes();

    public void setPersonneToDB(Personne p);
    
}
