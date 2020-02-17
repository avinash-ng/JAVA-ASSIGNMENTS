/**
 *  Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */


public class Constructor {
    String a;
    Constructor(){
        System.out.println("Inside constructor without parameters");
    }
    Constructor(String a){
        this();
        System.out.println("With parameters");
    }
    public static void main(String args[]){
        new Constructor("hi hello");
    }
}

