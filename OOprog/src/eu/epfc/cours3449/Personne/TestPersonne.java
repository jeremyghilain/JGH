
package eu.epfc.cours3449.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne p1=new Personne('M',"Ghilain","Jeremy");
        Personne p2=new Personne('F',"Gaska","Gosia");
        Personne p3=new Personne('M',"Malosse","Pascal");
        Personne p4=new Personne('M',"Ghilain","Jeremy");
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        
    }
}
