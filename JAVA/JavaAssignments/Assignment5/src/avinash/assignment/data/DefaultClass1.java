/**
 * Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized, add a method to print these variables.
 * Add another method in the same class with two local variables and print their values without initializing them.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.data;

import static java.lang.System.out;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DefaultClass1 {
    private int variable1;
    private char variable2;
    private Logger logger = Logger.getLogger(DefaultClass1.class.getName());
    public void printInstance(){
        logger.log(Level.INFO, "variable1 = "+ variable1);         //default int value is 0
        logger.log(Level.INFO, "variable2 = "+ variable2);         //prints unicode which is a default for character
    }

    public void printLocal(){
    /*    int local1, local2;
        logger.log(Level.INFO, "local1 = "+local1);
        logger.log(Level.INFO, "local2 = "+local2);
        This will not be executed because the local variables have not been initialized
    
    */
    }


}

