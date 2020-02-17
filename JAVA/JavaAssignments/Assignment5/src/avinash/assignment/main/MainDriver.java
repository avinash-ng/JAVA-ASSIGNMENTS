/**
 * Create main class in package yourname.assignment.main, create object of first class and call both the methods to print the values. Create object of second class using static method and then call the other method to print the String.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.main;
import data.DefaultDriver1;
import java.util.*;
import avinash.assignment.singleton.DefaultDriver2;

public class MainDriver {

    public static void main(String args[]){
        DefaultDriver1 d1;
        {
            d1 = new DefaultDriver1();
        }
        d1.printInstance();
        d1.printLocal(1,2);

        /**
         * calling setvar1 gives error, because it is a static method trying to access non-static variable
         *  DefaultDriver2 d2 = DefaultDriver2.setvar1("Hello");
         *  d2.print();
         */
    }

}
