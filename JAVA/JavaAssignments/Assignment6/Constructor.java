/**
 *  Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */

import java.util.logging.Logger;
import java.util.logging.Level;

public class Constructor {
    String string;
    Constructor(){
        logger.log(Level.INFO, "Inside default constructors");
    }
    
    Constructor(String localString){
        this();
        string = localString;
        logger.log(Level.INFO, "Inside a constructor with arguments");
    }
    
    public static void main(String args[]){
        new Constructor("hi hello");
    }
    
}

