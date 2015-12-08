// Bateau hérite de Vehicule (classe fille)

package eu.epfc.cours3449;

public class Bateau extends Vehicule {
    public double tirant;

    void larguerAmarres() {
        System.out.println("Bateau "+age+" - "+tirant+" largue les amarres");    
    }
    
    public static void main(String[] args) {
        Bateau b = new Bateau ();
        b.age=10;
        b.tirant=15;
        b.start();
        b.stop();
        b.larguerAmarres();
    }
    
}
