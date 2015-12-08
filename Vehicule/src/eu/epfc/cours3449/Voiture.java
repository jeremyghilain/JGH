package eu.epfc.cours3449;

public class Voiture extends Vehicule {
    
    double consomation;
    String couleur;
    
    public static void main(String[] args) {
        Voiture v = new Voiture();
        v.consomation=4.5;
        v.couleur="verte";
        v.age=15;
        v.start();
        v.stop();        
        // par défaut, il va utiliser les méthodes start et stop de Vehicule
        // a moins qu'on en crée d'autre dans cette classe ci       
    }
    
    @Override
    public void start() {
        System.out.println("Voiture "+couleur+" d'age "+age+" an(s) et de consomation "+consomation+" start");
    }
    
}
