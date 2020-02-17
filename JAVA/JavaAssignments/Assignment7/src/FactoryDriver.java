/**
 * Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
 * Create factories for each type of Cycle, and code that uses these factories.
 */


interface Cycle1{
   void print();
}

class Unicycle1 implements Cycle1{
    Unicycle1(){
        System.out.println("Inside unicycle constructor");
    }
    public void print(){
        System.out.println("printing unicycle.....");
    }
}

class Bicycle1 implements Cycle1{
    Bicycle1(){
        System.out.println("Inside Bicycle constructor");
    }
    public void print(){
        System.out.println("printing Bicycle.....");
    }
}

class Tricycle1 implements Cycle1{
    Tricycle1(){
        System.out.println("Inside Tricycle constructor");
    }
    public void print(){
        System.out.println("printing Tricycle.....");
    }
}

class CycleFactory{
    public Cycle1 getObject(String str){
        if (str.toLowerCase().equals("unicycle"))
            return new Unicycle1();
        else if(str.toLowerCase().equals("bicycle"))
            return new Bicycle1();
        else if(str.toLowerCase().equals("tricycle"))
            return new Tricycle1();
        else
            return null;
    }
}
public class FactoryDriver {
    public static void main(String args[]){
        CycleFactory cf = new CycleFactory();
        String createFor = "UNICYCLE";

        if(cf.getObject(createFor) instanceof Unicycle1)
            System.out.println("Created object successfully for unicycle ");
        else
            System.out.println("error in object creation");
    }
}
