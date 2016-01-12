
package eu.epfc.cours3449.Personne;

public class Independant extends Travailleur{
    private String noSociete;

    public Independant(String noSociete, char genre, String nom, String prenom, double revenus) {
        super(genre, nom, prenom, revenus);
        this.noSociete = noSociete;
    }

    public Independant(String noSociete, char genre, String nom, String prenom, double revenus, String profmail, String proftel) {
        super(genre, nom, prenom, revenus, profmail, proftel);
        this.noSociete = noSociete;
    }

    public Independant(String noSociete, char genre, String nom, String prenom, double age, String nationalite, String adresse, String mailadresse, String telephone, double revenus, String profmail, String proftel) {
        super(genre, nom, prenom, age, nationalite, adresse, mailadresse, telephone, revenus, profmail, proftel);
        this.noSociete = noSociete;
    }

    public String getNoSociete() {
        return noSociete;
    }

    public void setNoSociete(String noSociete) {
        this.noSociete = noSociete;
    }
    
    @Override
    public double calculImpots(){
        return getRevenus()*0.15;
    }
    
    
}
