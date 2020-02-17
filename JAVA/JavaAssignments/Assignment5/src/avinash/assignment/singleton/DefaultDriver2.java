/**
 * Create another class in package yourname.assignment.singleton containing a non static String member variable. Add a static method that takes String as parameter and initialize the member variable and then return object of that class.
 * Add a non static method to print the String.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.singleton;

public class DefaultDriver2 {
     String var1;

    /**
     * this method raises error since we are using non static variable inside a static method.
     * we can make var1 as static then we must make print method also static, or else
     * we can make method setVar1 as non static
     *
     *
     * public static DefaultDriver2 setVar1(String s){
     *         var1 = s;
     *         return new DefaultDriver2();
     *}
     *

     */
     public void print(){
              System.out.println(var1);
     }

}
