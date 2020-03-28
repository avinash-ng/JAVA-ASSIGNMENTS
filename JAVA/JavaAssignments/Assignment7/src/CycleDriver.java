/**
   * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
   * Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle.
   * Create instances of all three types and upcast them to an array of Cycle.
   * Try to call balance( ) on each element of the array and observe the results.
   * Downcast and call balance( ) and observe what happens.

*/
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

class Cycle {

    int speed;
    int wheels;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    void increaseSpeed(){
        speed += 10;
    }

    void applyBrakes(){
        speed -= 10;
    }

    void decreaseSpeed(){
        applyBrakes();
    }


}

class Unicycle extends Cycle{


    Logger logger = Logger.getLogger(Unicycle.class.getName());
    Unicycle(){
        wheels = 1;
        logger.log(Level.INFO, " Inside unicycle constructor ");
//         System.out.println("Inside unicyle constructor");
    }

    public void balance(){
         logger.log(Level.INFO, " unicycle balanced ");
//         System.out.println("unicycle balanced");
    }

}

class Bicycle extends Cycle{


   Logger logger = Logger.getLogger(Bicycle.class.getName());
   Bicycle(){
        wheels = 2;
        logger.log(Level.INFO, " Inside bicycle constructor ");
//         System.out.println("Inside bicyle constructor");
    }

    public void balance(){
        logger.log(Level.INFO, " bicycle balanced ");
//         System.out.println("bicycle balanced");
      
    }

}
class Tricycle extends Cycle{


    Logger logger = Logger.getLogger(Tricycle.class.getName());
    Tricycle(){
        wheels = 1;
//         System.out.println("Inside Tricycle constructor");
        logger.log(Level.INFO, " inside Tricycle constructor " );
    }

}

class CycleDriver{
    public static void main(String args[]){
        Logger logger = Logger.getLogger(CycleDriver.class.getName());
        Unicycle ucycle = new Unicycle();
        Bicycle bcycle = new Bicycle();
        Tricycle tcycle = new Tricycle();

        Cycle cycle_arr[] = new Cycle[3];
        cycle_arr[0] = ucycle;
        cycle_arr[1] = bcycle;
        cycle_arr[2] = tcycle;

        int i;
        try {
//            throws error -------- cannot find balance() for Cycle
//            calling balance after upcasting
//            for (i = 0; i < 3; i++) {
//                cycle_arr[i].balance();
//            }

//          throws error ---------- cannot find balance() for Tricycle
//            calling balance after downcasting
            ((Unicycle)cycle_arr[0]).balance();
            ((Bicycle)cycle_arr[0]).balance();
//            ((Tricycle)cycle_arr[0]).balance();
        }
        catch(Exception ex){
//             System.out.println("Cannot find balance() method");
            logger.log(Level.INFO, " Cannot find balance() method ");
        }
    }
}
