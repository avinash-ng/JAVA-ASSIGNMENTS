/**
 * Create main class in package yourname.assignment.main, create object of first class and call both the methods to print the values. Create object of second class using static method and then call the other method to print the String.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.main;
import avinash.assignment.data.DefaultClass1;
import java.util.*;
import avinash.assignment.singleton.DefaultClass1;

public class MainDriver {

    public static void main(String args[]){
        DefaultClass1 dClass1Obj;
        {
            dClass1Obj = new DefaultClass1();
        }
        dClass1Obj.printInstance();
       
        /**
         * dClass1Obj.printLocal();
         * printLocal also gives error because of localvariables not initialized 
         */
        
        /**
         * calling setString gives error, because it is a static method trying to access non-static variable
         *  DefaultClass2 dClass2Obj = DefaultClass2.setString("Hello");
         *  dClass2Obj.print();
         */
    }

}
