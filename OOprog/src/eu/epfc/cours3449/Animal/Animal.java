package eu.epfc.cours3449.Animal;

public class Animal {
    private double age=0;

    public Animal(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" + "age=" + age + '}';
    }
    
    public void grandit(){
        this.age=age+1;
    }
    
    public void grandit(int duree) {
        for(int i=0;i<duree;i++){
            grandit();
        }
    }
}
