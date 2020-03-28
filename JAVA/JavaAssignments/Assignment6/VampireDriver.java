/**
 * 1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order.
 *  Write a java program to print first 100 vampire numbers.
 */

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;
class Vampire
{
    boolean hasDigits(int param1, int param2){
       int arr1[] = new int[10];
       int index;
       while(param1 > 0){
           index = param1%10;
           arr1[index] += 1;
           param1 = param1/10;
       }

       int arr2[] = new int[10];
       while(param2 > 0){
           index = param2%10;
           arr2[index] += 1;
           param2 = param2/10;
       }
       int i;
       for(i=0; i<10; i++){
           if(arr1[i] >= arr2[i])
               continue;
           return false;
       }
       return true;
    }

    boolean containTrailingZeros(int number){
        if(number%10 == 0)
            return true;
        return false;
    }

    int countDigits(int number){
        int count = 0;
        while(number/10 > 0){
            count += 1;
            number = number/10;
        }
        count += 1;
        return count;
    }

    boolean isVampireNumber(int number){
        int number_digits = countDigits(number);
        if(number_digits%2 != 0)
            return false;
        int num, number_sqrt = (int)Math.sqrt(number);

        for(num =2; num<=number_sqrt; num++){
            if(number%num != 0)
                continue;

            if((countDigits(num) == number_digits/2) && (countDigits(number/num) == number_digits/2)) {
                if(((containTrailingZeros(num))) && containTrailingZeros(number/num))
                    return false;

                   int digits =  countDigits(number/num);
                    int number1 = num*(int)Math.pow(10, digits) + (number/num);
                    if (hasDigits(number, number1))
                    {
                         return true;
                    }
                }
            else
                continue;
            }


        return false;
    }
}
public class VampireDriver {

    public static void main(String args[]) {
        Logger logger = Logger.getAnonymousLogger();
        Vampire vampire = new Vampire();
        int number, count = 0;
        for (number = 11; ; number++) {
            if (count < 100) {
                if (vampire.isVampireNumber(number)) {
                    logger.info(number + " is a vampire number ");
                    count += 1;
                }
            }
        }
//        System.out.println(v.isVampireNumber(1275));

    }
}
