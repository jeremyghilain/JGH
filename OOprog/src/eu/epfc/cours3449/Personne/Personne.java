
package eu.epfc.cours3449.Personne;

public class Personne {
    private char genre; // M ou F
    private String nom;
    private String prenom;
    private double age; // en années
    private String nationalite;
    //private String adresse; // complète: rue,numero,ville,pays
    private Addresse addresse;
    private String mailadresse;
    private String telephone;
    
    /*
    public Personne(){
        this.genre='M';
        this.nom="John";
        this.prenom="Doe";
    }
    
    public Personne(char genre, String nom, String prenom){
        this.genre=genre;
        this.nom=nom;
        this.prenom=prenom;
    }

    public Personne(char genre, String nom, String prenom, double age, String nationalite, String adresse, String mailadresse, String telephone) {
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.mailadresse = mailadresse;
        this.telephone = telephone;
    }
    */
    public char getGenre(){
        return genre;
    }
    
    public void setGenre(char genre){
        this.genre=genre;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public String getPrenom(){
        return nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    
    public double getAge(){
        return age;
    }
    
    public void setAge(double age) {
        if (age<0 || age>200) {
            throw new IllegalArgumentException("Impossible age, please select another");
        }
        this.age=age;
    }
    
    public String getNationalite(){
        return nationalite;
    }
    
    public void setNationalite(String nationalite){
        this.nationalite=nationalite;
    }

    public Addresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }

    public String getMailadresse() {
        return mailadresse;
    }

    public void setMailadresse(String mailadresse) {
        this.mailadresse = mailadresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getTitre(){
        String titre;
        if(genre=='M') titre="M";
        else if(genre=='F') titre="Mme";
        else titre="La personne";
        return titre;
    }
    
    public String headToString(){
        return getTitre()+" "+nom+" "+prenom;
    }
    
    public String tailToString(){
        return ", de nationalité "+nationalite+", ayant pour adresse "+getAddresse()+", pour adresse mail "+mailadresse+" et comme numero de telephone "+telephone;
    }
    
    
    
    /*
    public String toString() {
        return headToString()+" "+tailToString();
    }
    
    
    public boolean equals(Personne p){
        boolean isequal=false;
        if (genre==p.getGenre() && getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom()) 
                && age==p.getAge() && getNationalite().equals(p.getNationalite()) 
                && getAdresse().equals(p.getAdresse()) && getMailadresse().equals(p.getMailadresse()) 
                && getTelephone().equals(p.getTelephone()))
            isequal=true;
        return isequal;
    }
    
    /*
    public boolean equals(char genre, String nom, String prenom, double age, String nationalite, String adresse, String mailadresse, String telephone){
        boolean isequal=false;
        if (this.genre==genre && this.nom.equals(nom) && this.prenom.equals(prenom) 
                && this.nom.equals(nom) && this.age==age && this.nationalite.equals(nationalite) 
                && this.adresse.equals(adresse) && this.mailadresse.equals(mailadresse) 
                && this.telephone.equals(telephone)) {
            isequal=true;
        }
        return isequal;
    }
    */

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", addresse=" + addresse + '}';
    }
    
    
    
    
}
