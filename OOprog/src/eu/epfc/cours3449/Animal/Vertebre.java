
package eu.epfc.cours3449.Animal;

public class Vertebre extends Animal{
    private int nbvertebre;

    public Vertebre(double age, int nbvertebre) {
        super(age);
        this.nbvertebre = nbvertebre;
    }

    public int getNbvertebre() {
        return nbvertebre;
    }

    public void setNbvertebre(int nbvertebre) {
        this.nbvertebre = nbvertebre;
    }

    @Override
    public String toString() {
        return "Vertebre{" + "age=" + getAge() + " , nbvertebre=" + nbvertebre + '}';
    }
    
    @Override
    public void grandit() {
        super.grandit();
        this.nbvertebre=nbvertebre+2;
    }
    
    /*
    @Override
    public void grandit() {
        this.nbvertebre=nbvertebre+1;
    }
    
    public void grandit(int aggrandissement) {
        this.nbvertebre=nbvertebre+aggrandissement;
    }
    */
}
