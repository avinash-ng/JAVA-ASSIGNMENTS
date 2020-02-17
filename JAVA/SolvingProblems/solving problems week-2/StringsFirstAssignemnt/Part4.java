
/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
2. Use URLResource to read the file at http://www.dukelearntoprogram.com/course2/data/manylinks.html word by word.

3. For each word, check to see if “youtube.com” is in it. If it is, find the double quote to the left and right of the occurrence of “youtube.com” to identify the beginning and end of the URL. Note, the double quotation mark is a special character in Java. To look for a double quote, look for (\”), since the backslash (\) character indicates we want the literal quotation marks (“) and not the Java character. The string you search for would be written “\”” for one double quotation mark.

4. In addition to the String method indexOf(x, num), you might want to consider using the String method lastIndexOf(s, num) that can be used with two parameters s and num. The parameter s is the string or character to look for, and num is the last position in the string to look for it. This method returns the last match from the start of the string up to the num position, so it is a good option for finding the opening quotation mark of a string searching backward from “youtube.com.” More information on String methods can be found in the Java documentation for Strings: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html.
 
 */
import edu.duke.*;
public class Part4
{
    public void findWebLinks()
    {
        String urlToLook = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource ur = new URLResource(urlToLook);
        
        for(String word : ur.words())  {
               word = word.toLowerCase();
               if(word.contains("youtube.com"))  {
                    int ind = word.indexOf("\"");
                    int ind2 = word.lastIndexOf("\"");
                    System.out.println(word.substring(ind+1, ind2));
               }
        }
    }
}
