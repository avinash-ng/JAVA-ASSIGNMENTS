
/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
2. Write the method named twoOccurrences that has two String parameters named stringa and stringb. This method returns true if stringa appears at least twice in stringb, otherwise it returns false. For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurence of “atg”.

3. Write the void method named testing that has no parameters. This method should call twoOccurrences on several pairs of strings and print the strings and the result of calling twoOccurrences (true or false) for each pair. Be sure to test examples that should result in true and examples that should result in false.

4. Write the method named lastPart that has two String parameters named stringa and stringb. This method finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. If stringa does not occur in stringb, then return stringb. For example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word.

5. Add code to the method testing to call the method lastPart with several pairs of strings. For each call print the strings passed in and the result. For example, the output for the two calls above might be:

The part of the string after an in banana is ana.
The part of the string after zoo in forest is forest.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Part3
{
    boolean twoOccurences(String stringa, String stringb){
        Pattern p = Pattern.compile(stringa);
        Matcher m = p.matcher(stringb);
        int count = 0;
        while(m.find()) {
            count += 1;
        }
        if(count >=2)   return true;
        return false;
    }
    
    void testing(){
        System.out.println(twoOccurences("abcd", "abcdabdddabcd"));
        System.out.println(lastPart("zoo", "forest"));
    }
    
    
    public String lastPart(String stringa, String stringb)    {
        int ind = stringb.indexOf(stringa);
        if(ind != -1)   {
            return stringb.substring(ind);
        }
        return stringb;
    }
}
    

