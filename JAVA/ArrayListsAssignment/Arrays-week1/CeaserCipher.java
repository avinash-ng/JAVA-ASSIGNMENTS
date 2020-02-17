
/**
 * Write a description of class CeaserCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class CeaserCipher
{
    static char lowerCase[] = new char[]{'a', 'b', 'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static char upperCase[] = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public String encrypt(String input, int key){
        int i, len = input.length(), g, ind;
        String s = "";
        char tobeAdd;
        for(i=0; i<len; i++)
        {
            char ch = input.charAt(i);
            if((ch >= 'a' && ch <='z') ||(ch >='A' && ch <= 'Z'))
            {
                
            if(Character.isUpperCase(ch))
            {
                g = (int)ch%65;
                ind = (g+key)%26;
                tobeAdd = upperCase[ind];
            }
            else
            {
                g = (int)ch%97;
                ind = (g+key)%26;
                tobeAdd = lowerCase[ind];
            }
            s += String.valueOf(tobeAdd);
            }
            else
            {
                s += String.valueOf(ch);
            }
        }
        return s;
        
    }
    
    public void testCeaser(){
        int key=17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        String encrypted = encrypt(message, key);
        System.out.println("key is "+key+"\n"+encrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String s = "";
        int i, len=input.length();
        for(i=0; i<len; i++){
            char c = input.charAt(i);
            if(Character.isLetter(c))   {
                
            if(i%2 == 0)
            {
                if(Character.isLowerCase(c))
                    s += String.valueOf(lowerCase[(((int)c)%97+key1)%26]);
                else
                    s += String.valueOf(upperCase[(((int)c)%65+key1)%26]);
            }
            else
            {
                if(Character.isLowerCase(c))
                    s += String.valueOf(lowerCase[(((int)c)%97+key2)%26]);
                else
                    s += String.valueOf(upperCase[(((int)c)%65+key2)%26]);
            }
           
        }
        else
            s += String.valueOf(c);
        }
        System.out.println(s);
        return s;
    }
}
