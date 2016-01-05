
package eu.epfc.cours3449.Personne;

public class Employe extends Personne{
    private String trigram;
    private String niveau;
    private String departement;
    private String profmail;
    private String proftel;

    public Employe(String trigram, String niveau, String departement, String profmail, String proftel) {
        this.trigram = trigram;
        this.niveau = niveau;
        this.departement = departement;
        this.profmail = profmail;
        this.proftel = proftel;
    }
    
    public Employe(char genre, String nom, String prenom, String trigram, String niveau, String departement, String profmail, String proftel) {
        super(genre, nom, prenom);
        this.trigram = trigram;
        this.niveau = niveau;
        this.departement = departement;
        this.profmail = profmail;
        this.proftel = proftel;
    }

    public Employe(char genre, String nom, String prenom, String trigram, String niveau, String departement, String profmail, String proftel, double age, String nationalite, String adresse, String mailadresse, String telephone) {
        super(genre, nom, prenom, age, nationalite, adresse, mailadresse, telephone);
        this.trigram = trigram;
        this.niveau = niveau;
        this.departement = departement;
        this.profmail = profmail;
        this.proftel = proftel;
    }

    public String getTrigram() {
        return trigram;
    }

    public void setTrigram(String trigram) {
        this.trigram = trigram;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
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
    
    public String employeeToString(){
        return "trigram "+trigram+", "+niveau+", departement "+departement+", mail professionel "+profmail+", telephone professionel "+proftel;
    }
    
    @Override
    public String toString() {
        return headToString()+" ("+employeeToString()+") "+tailToString();
    }

            
}
