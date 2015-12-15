// Bateau hérite de Vehicule (classe fille)

package eu.epfc.cours3449.vehicule;

public class Bateau extends Vehicule {
    public double tirant;

    void larguerAmarres() {
        System.out.println("Bateau "+getAge()+" - "+tirant+" largue les amarres");    
    }
    
    public static void main(String[] args) {
        Bateau b = new Bateau ();
        b.setAge(10);
        b.tirant=15;
        b.start();
        b.stop();
        b.larguerAmarres();
        
        Vehicule v =b;
        v.setAge(11);
        // c'est le même objet que plus haut, il n'y a pas de "new"
        System.out.println(b.getAge());
        v.start();
        v.stop();
    }
    
}
