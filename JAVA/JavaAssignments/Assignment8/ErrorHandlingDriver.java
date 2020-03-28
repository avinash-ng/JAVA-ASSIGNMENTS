/**
 *  Create three new types of exceptions.
 *  Write a class with a method that throws all three.
 *  In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
 *  Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 */




import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;

class ExceptionOne extends Exception{
    Logger logger = Logger.getLogger(ExceptionOne.class.getName());
    ExceptionOne(String message){
//         System.out.println("ExceptionOne raised "+message);
        logger.log(Level.INFO, " ExceptionOne raised "+message);
    }
}

class ExceptionTwo extends Exception{
    Logger logger = Logger.getLogger(ExceptionTwo.class.getName());
    ExceptionTwo(String message){
//         System.out.println("ExceptionTwo raised "+message);
        logger.log(Level.INFO, " ExceptionTwo raised "+message);
    }
}

class ExceptionThree extends Exception{
    Logger logger = Logger.getLogger(ExceptionThree.class.getName());
    ExceptionThree(String message){
//         System.out.println("ExceptionThree raised "+message);
        logger.log(Level.INFO, " ExceptionThree raised "+message);
    }
}


public class ErrorHandlingDriver {
    Logger logger = Logger.getLogger(ErrorHandlingDriver.class.getName());
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
//             System.out.println("Exception caught");
            logger.log(Level.SEVERE, " Exception caught ");
        }
    
    
        finally {
//             System.out.println("Inside finally clause");
            logger.log(Level.INFO, " Inside finally clause ");
        }
    }
}
