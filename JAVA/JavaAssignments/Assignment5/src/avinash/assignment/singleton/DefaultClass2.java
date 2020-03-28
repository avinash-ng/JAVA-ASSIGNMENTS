/**
 * Create another class in package yourname.assignment.singleton containing a non static String member variable. Add a static method that takes String as parameter and initialize the member variable and then return object of that class.
 * Add a non static method to print the String.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.singleton;

public class DefaultClass2 {
     String string;

    /**
     * this method raises error since we are using non static variable inside a static method. We have two options 
     * 1. we can make "string" variable as static then we must make print method also static, or else
     * 2. we can make method setString as non static
     *
     *
     * public static DefaultClass2 setString(String s){
     *         string = s;
     *         return new DefaultClass2();
     *}
     *

     */
     public void print(){
               Logger logger = Logger.getLogger(DefaultClass2.class.getName());
               logger.log(Level.INFO, "string = "+string);
     }

}
