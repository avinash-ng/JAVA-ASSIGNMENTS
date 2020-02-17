/**
 * 1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order.
 *  Write a java program to print first 100 vampire numbers.
 */

import java.util.*;
class Vampire
{
    boolean hasDigits(int a, int b){
       int arr1[] = new int[10];
       int ind;
       while(a > 0){
           ind = a%10;
           arr1[ind] += 1;
           a = a/10;
       }

       int arr2[] = new int[10];
       while(b > 0){
           ind = b%10;
           arr2[ind] += 1;
           b = b/10;
       }
       int i;
       for(i=0; i<10; i++){
           if(arr1[i] >= arr2[i])
               continue;
           return false;
       }
       return true;
    }

    boolean containTrailingZeros(int a){
        if(a%10 == 0)
            return true;
        return false;
    }

    int countDigits(int a){
        int count = 0;
        while(a/10 > 0){
            count += 1;
            a = a/10;
        }
        count += 1;
        return count;
    }

    boolean isVampireNumber(int a){
        int digits = countDigits(a);
        if(digits%2 != 0)
            return false;
        int i, j = (int)Math.sqrt(a);

        for(i=2; i<=j;i++){
            if(a%i != 0)
                continue;
//           System.out.println(i+" "+(a/i));
            if((countDigits(i) == digits/2) && (countDigits(a/i) == digits/2)) {
                if(((containTrailingZeros(i))) && containTrailingZeros(a/i))
                    return false;

                   int cn =  countDigits(a/i);
                    int number = i*(int)Math.pow(10, cn) + (a/i);
                    if (hasDigits(a, number))
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
        Vampire v = new Vampire();
        int i, count = 0;
        for (i = 1260; ; i++) {
            if (count < 100) {
                if (v.isVampireNumber(i)) {
                    System.out.println(i);
                    count += 1;
                }
            }
        }
//        System.out.println(v.isVampireNumber(1275));

    }
}
