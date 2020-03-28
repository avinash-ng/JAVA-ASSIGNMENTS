/**
    5. Create a class with an inner class that has a non-default constructor (one that takes arguments). Create a second class with an inner class that inherits from the first inner class.
*/


import java.util.logging.Logger;
import java.util.logging.Level;

class Outer{
    
    class Inner{
        Logger logger = Logger.getLogger(Inner.class.getName());
        Inner(String string){
            // System.out.println(s);
            // System.out.println("Inside inner of outer ");

            logger.log(Level.INFO, " string = "+ string);
            logger.log(Level.INFO, " Inside inner of outer ");
        }
    }
}


class Outer1{
    
    
    
    class Inner1 extends Outer.Inner{
        Logger logger = Logger.getLogger(Inner1.class.getName());    
        Inner1(Outer outer){
            
            outer.super("Hello");
            // System.out.println("creating inner1 class of outer1");
            logger.log(Level.INFO, " creating inner1 class of outer1 ");
        
        }
    
    }

}



public class InnerClassDriver {
    public static void main(String args[]){
        Outer outer = new Outer();
        Outer1 outer1 = new Outer1();
        Outer1.Inner1 in = outer1.new Inner1(outer);
        

    }
}
