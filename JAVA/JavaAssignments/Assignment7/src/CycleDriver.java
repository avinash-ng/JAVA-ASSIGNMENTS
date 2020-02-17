/**
   * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
   * Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle.
   * Create instances of all three types and upcast them to an array of Cycle.
   * Try to call balance( ) on each element of the array and observe the results.
   * Downcast and call balance( ) and observe what happens.

*/
import java.util.*;
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


    Unicycle(){
        wheels = 1;
        System.out.println("Inside unicyle constructor");
    }

    public void balance(){
        System.out.println("unicycle balanced");
    }

}

class Bicycle extends Cycle{


   Bicycle(){
        wheels = 2;
        System.out.println("Inside bicyle constructor");
    }

    public void balance(){
        System.out.println("bicycle balanced");
    }

}
class Tricycle extends Cycle{


    Tricycle(){
        wheels = 1;
        System.out.println("Inside Tricycle constructor");
    }

}

class CycleDriver{
    public static void main(String args[]){
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
            System.out.println("Cannot find balance() method");
        }
    }
}
