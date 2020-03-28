/**
  * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
  * In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent.
  * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens.
  * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.

*/
import java.util.logging.Logger;
import java.util.logging.Level;

abstract class Rodents {

   abstract void print();
//   {
//        System.out.println("printing rodents........");
//    }

    abstract void eat();
//    {
//        System.out.println("Rodents eating.......");
//    }
}

class Mouse extends Rodents{
    Logger logger = Logger.getLogger(Mouse.class.getName());
    Mouse(){
//         System.out.println("Inside Mouse constructor....");
         logger.log(Level.INFO, " Inside Mouse constructor...... ");
    }

    void eat(){
//         System.out.println("Mouse eating.........");
       logger.log(Level.INFO, " Mouse Eating.......... ");
    }

    void print(){
//         System.out.println("Printing Mouse.............");
       logger.log(Level.INFO, " Printing Mouse...........");
    }

    void mouseSpecific(){
//         System.out.println("Function specific to mouse");
       logger.log(Level.INFO, " Function specific to mouse ");
    }
}

class Gerbil extends Rodents{
   Logger logger = Logger.getLogger(Gerbil.class.getName());
   Gerbil(){
//         System.out.println("Inside gerbil constructor....");
         logger.log(Level.INFO, " Inside gerbil constructor........... ");

    }

    void eat(){
//         System.out.println("Gerbil eating.........");
        logger.log(Level.INFO, " Gerbil eating........... ");
    }

    void print(){
         logger.log(Level.INFO, " Printing Gerbil........... ");
//         System.out.println("Printing Gerbil.............");
    }

    void gerbilSpecific(){
         logger.log(Level.INFO, " Function specific to gerbil ");
//         System.out.println("Function specific to gerbil");
    }
}

class Hamster extends Rodents{
    Logger logger = Logger.getLogger(Hamster.class.getName());
    Hamster(){
//         System.out.println("Inside hamster constructor....");
        logger.log(Level.INFO, " Inside hamster constructor........ ");
       
    }


    void eat(){
//         System.out.println("Hamster eating.........");
         logger.log(Level.INFO, " Hamster eating............ ");
    }

    void print(){
//         System.out.println("Printing hamster.............");
         logger.log(Level.INFO, " Printing hamster............. ");
    }

    void hamsterSpecific(){
//         System.out.println("Function specific to hamster");
         logger.log(Level.INFO, " Function specific to hamster ");
    }
}


class RodentDriver{
    public static void main(String args[]){
        Rodents rodent_arr[] = new Rodents[3];
        rodent_arr[0] = new Mouse();
        rodent_arr[1] = new Gerbil();
        rodent_arr[2] = new Hamster();
        for(int i=0; i<3; i++){
            rodent_arr[i].print();
            rodent_arr[i].eat();
        }
    }
}
