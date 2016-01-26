
package eu.epfc.cours3449.Personne;

public class Employe extends Travailleur {
    private String employeur;
    private String departement;
    private String identifiant;
    private String niveau;
/*
    public Employe(char genre, String nom, String prenom, double revenus, String employeur, String departement, String identifiant, String niveau) {
        super(genre, nom, prenom, revenus);
        this.employeur = employeur;
        this.departement = departement;
        this.identifiant = identifiant;
        this.niveau = niveau;
    }

    public Employe(char genre, String nom, String prenom, double age, String nationalite, String adresse, String mailadresse, String telephone, double revenus, String profmail, String proftel, String employeur, String departement, String identifiant, String niveau) {
        super(genre, nom, prenom, age, nationalite, adresse, mailadresse, telephone, revenus, profmail, proftel);
        this.employeur = employeur;
        this.departement = departement;
        this.identifiant = identifiant;
        this.niveau = niveau;
    }*/
    
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String compagnie) {
        this.employeur = compagnie;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
   
    public String employeeToString(){
        return "Compagnie " +employeur+", département " +departement+", niveau"+niveau +", identifiant "+identifiant;
    }
    
    @Override
    public String toString() {
        return headToString()+" ("+employeeToString()+", "+travailleurToString()+") "+tailToString();
    }
    
    @Override
    public double calculImpots(){
        return getRevenus()*0.35;
    }
    
            
}
