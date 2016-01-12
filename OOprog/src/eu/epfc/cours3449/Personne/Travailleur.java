
package eu.epfc.cours3449.Personne;

public abstract class Travailleur extends Personne {
    private double revenus; // par ans
    private String profmail;
    private String proftel;
    
    public Travailleur(char genre, String nom, String prenom, double revenus) {
        super(genre, nom, prenom);
        this.revenus = revenus;
    }
    
    public Travailleur(char genre, String nom, String prenom, double revenus, String profmail, String proftel) {
        super(genre, nom, prenom);
        this.revenus = revenus;
        this.profmail = profmail;
        this.proftel = proftel;
    }

    public Travailleur(char genre, String nom, String prenom, double age, String nationalite, String adresse, String mailadresse, String telephone, double revenus, String profmail, String proftel) {
        super(genre, nom, prenom, age, nationalite, adresse, mailadresse, telephone);
        this.revenus = revenus;
        this.profmail = profmail;
        this.proftel = proftel;
    }

    public double getRevenus() {
        return revenus;
    }

    public void setRevenus(double revenus) {
        this.revenus = revenus;
    }

    public String getProfmail() {
        return profmail;
    }

    public void setProfmail(String profmail) {
        this.profmail = profmail;
    }

    public String getProftel() {
        return proftel;
    }

    public void setProftel(String proftel) {
        this.proftel = proftel;
    }
    
    
    public abstract double calculImpots();
    
    
    public String travailleurToString(){
        return "revenus "+revenus+", mail professionel "+profmail+", telephone professionel "+proftel;
    }
    
}
