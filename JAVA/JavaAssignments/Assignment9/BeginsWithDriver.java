/**
 * Using the documentation for java.util.regex.Pattern as a resource.
 * write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
*/

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BeginsWithDriver {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String regex = "^[A-Z].*[.]$";
        String input = sc.next();
        Pattern p = Pattern.compile(regex);
        Matcher obj = p.matcher(input);
        boolean val = obj.matches();
        System.out.print(val);
    }
}
