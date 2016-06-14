
package eu.epfc.cours3449.ExamJGhilain1_Model;

public class Personne {
    private String nom;
    private String prenom;
    private String age;
    private String telephone;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public void toDisplay() {
        String format = "%-15s %-15s  %-5s %-15s \n";
        System.out.format(format, nom, prenom,age,telephone);        
    }
}
