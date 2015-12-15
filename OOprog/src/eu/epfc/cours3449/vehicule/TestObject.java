
package eu.epfc.cours3449.vehicule;

import java.util.*;

public class TestObject {
    double d=273.15;
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        System.out.println(o1.toString());
        System.out.println(o1.hashCode());
        System.out.println(Integer.toHexString(o1.hashCode()));
        System.out.println();
        
        System.out.println(o1.equals(o2));
        o2=o1;
        System.out.println(o1.equals(o2));
        String s1=new String("s1");
        String s2=new String("s2");
        System.out.println(s1.equals(s2));
        s2="s1";
        System.out.println(s1.equals(s2));
                
        System.out.println(s1.equals(o2));
        o2=s1;
        System.out.println(s1.equals(o2));
        
        System.out.println();
        
        Object[] os =new Object[3];
        os[0]=o1;
        //os[1]=new Button("Coucou"); // interdit pour le java FX
        os[1]=new Vehicule();
        os[2]=new String("This is a String");
        for (int i=0;i<os.length;i++) {
            System.out.println(os[i].toString());
        }
        
    }
    
    @Override
    public String toString() {
        return "TestObject " +d;
    }
    
}
