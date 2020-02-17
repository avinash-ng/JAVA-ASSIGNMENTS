/**
 * Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized, add a method to print these variables.
 * Add another method in the same class with two local variables and print their values without initializing them.
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */

package avinash.assignment.data;

import static java.lang.System.out;

public class DefaultDriver1 {
    int variable1;
    char variable2;

    public void printInstance(){
        out.println(variable1);         //default int value is 0
        out.println(variable2);         //prints unicode which is a default for character
    }

    public void printLocal(int local1, int local2){
        out.println(local1);
        out.println(local2);
    }
}

