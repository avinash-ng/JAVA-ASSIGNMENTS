/**
 *  Create three new types of exceptions.
 *  Write a class with a method that throws all three.
 *  In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
 *  Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 */





import java.util.*;

class ExceptionOne extends Exception{
    ExceptionOne(String message){
        System.out.println("ExceptionOne raised "+message);
    }
}

class ExceptionTwo extends Exception{
    ExceptionTwo(String message){
        System.out.println("ExceptionTwo raised "+message);
    }
}

class ExceptionThree extends Exception{
    ExceptionThree(String message){
        System.out.println("ExceptionThree raised "+message);
    }
}


public class ErrorHandlingDriver {
    public static void  throwException(int arr[]) throws ExceptionOne, ExceptionTwo, ExceptionThree{
       int i, l= arr.length;

       if(l <= 0)
           throw new ExceptionThree("no elements found");
       for(i=0; i<l; i++){
           if(arr[i] < 0)
               throw  new ExceptionTwo("negative element found");
           if(arr[i] %2 != 0)
               throw new ExceptionOne("found Odd element");
       }
    }

    public static void main(String args[]){

        try {
            int even_arr[] = new int[]{-1, 2, 4, 6, 8, 9};
            int arr[] = null;
            throwException(arr);
        }
        catch (ExceptionOne | ExceptionTwo  | ExceptionThree ex){
            System.out.println("Exception caught");
        }
    
    
        finally {
            System.out.println("Inside finally clause");
        }
    }
}
