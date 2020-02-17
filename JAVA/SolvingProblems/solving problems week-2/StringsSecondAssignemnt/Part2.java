
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * 
 * 1. Create a new Java Class named Part2in the StringsSecondAssignments project.

2. Write the method named howMany that has two String parameters named stringa and stringb. This method returns an integer indicating how many times stringa appears in stringb, where each occurrence of stringa must not overlap with another occurrence of it. For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.

3.Write the void method testHowMany has no parameters. Add code in here to call howMany with several examples and print the results. Think carefully about what types of examples would be good to test to make sure your method works correctly.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Part2
{
    // instance variables - replace the example below with your own
    int howMany(String stringa, String stringb)    {
        int count =0;
        Pattern p = Pattern.compile(stringa);
        Matcher obj = p.matcher(stringb);
        while(obj.find())   {
            count += 1;
        }
        return count;
    }
    
    
    void testHowMany(){
        String stringa1 = "GAA";
        String stringb1 = "ATGAACGAATTGAATC";
        
        int c = howMany(stringa1, stringb1);
        if(c != 3)  System.out.println("error with count which should be 3");
        
        String stringa2 = "AAA";
        String stringb2 = "ATGAAAAA";
        int c1 = howMany(stringa2, stringb2);
        if(c1 != 1) System.out.println("error with count which sould be 1");
        
        System.out.println("tests finished");
        
    }
}

