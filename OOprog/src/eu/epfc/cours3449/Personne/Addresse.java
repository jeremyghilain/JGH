
package eu.epfc.cours3449.Personne;

public class Addresse {
    private String rue; //rue + numéro + boite
    private String ville; //code postal+département+ville

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Addresse{" + "rue=" + rue + ", ville=" + ville + '}';
    }
    
    
    
}
