/**
 * 3. Create a class with a constructor that takes a String argument. During construction, print the argument.
 * Create an array of object references to this class, but don’t actually create objects to assign into the array.
 * When you run the program, notice whether the initialization messages from the constructor calls are printed.
 *
 * 4. Complete the previous exercise by creating objects to attach to the array of references.
 */
import java.util.logging.Logger;
import java.util.logging.Level;

public class ThirdOne {

    static String string;
    ThirdOne(String localString){
        string = localString;
        logger.log(Level.INFO, "string = "+string);

    }
    public static void main(String args[]){
        ThirdOne[] obj = new ThirdOne[10];
        for (int i=0; i<10; i++){
            obj[i] = new ThirdOne("hello");
        }
    }
}

