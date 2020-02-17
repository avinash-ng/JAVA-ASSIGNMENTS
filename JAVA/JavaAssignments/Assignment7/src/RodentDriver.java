/**
  * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
  * In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent.
  * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens.
  * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.

*/
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
    Mouse(){
        System.out.println("Inside Mouse constructor....");
    }

    void eat(){
        System.out.println("Mouse eating.........");
    }

    void print(){
        System.out.println("Printing Mouse.............");
    }

    void mouseSpecific(){
        System.out.println("Function specific to mouse");
    }
}

class Gerbil extends Rodents{

   Gerbil(){
        System.out.println("Inside gerbil constructor....");
    }

    void eat(){
        System.out.println("Gerbil eating.........");
    }

    void print(){
        System.out.println("Printing Gerbil.............");
    }

    void gerbilSpecific(){
        System.out.println("Function specific to gerbil");
    }
}

class Hamster extends Rodents{

    Hamster(){
        System.out.println("Inside hamster constructor....");
    }


    void eat(){
        System.out.println("Hamster eating.........");
    }

    void print(){
        System.out.println("Printing hamster.............");
    }

    void hamsterSpecific(){
        System.out.println("Function specific to hamster");
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
