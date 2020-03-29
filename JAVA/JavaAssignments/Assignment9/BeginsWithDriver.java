/**
 * Using the documentation for java.util.regex.Pattern as a resource.
 * write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
*/

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BeginsWithDriver {
    public static boolean startsWithCapsAndEndsWithPeriod(String input) {
        String regex = "^[A-Z].*[.]$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcherObj = pattern.matcher(input);
         return matcherObj.matches();
    }
    public static void main(String args[]){
        Logger logger = Logger.getLogger(BeginsWithDriver.class.getName());
        Scanner sc = new Scanner(System.in);        
        String input = sc.next();
        boolean hasregex = startsWithCapsAndEndsWithPeriod(input);
        if(hasregex == true)    
              logger.log(Level.INFO, " has regex ");
        else
            logger.log(Level.INFO, " does not have regex ");
       
        
    }
}
