
package eu.epfc.cours3449.vehicule;

public class TestVehicule {
    public static void main(String[] args) {
        Vehicule[] vs= new Vehicule[4];
        
        vs[0]=new Vehicule();
        vs[0].setAge(1);
        
        vs[1]=new Bateau();
        vs[1].setAge(12);
        
        vs[2]=new Voiture();
        vs[2].setAge(4);
        
        vs[3]=new Bateau();
        vs[3].setAge(20);
        
        for(int i=0; i<vs.length; i++) {
            vs[i].start();
        }
        for(int i=0; i<vs.length; i++) {
            vs[i].stop();
        }
    }
}
