
/**
 * Write a description of class TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher
{
    // instance variables - replace the example below with your own
    public int[] countLetters(String s) {
        int counts[] = new int[26];
        int i, l = s.length();
        for(i=0; i<l; i++) {
                if(Character.isLetter(s.charAt(i))) {
                    char c = Character.toLowerCase(s.charAt(i));
                    int ind = (int)c%97;
                    counts[ind] += 1;
                }
            }
         return counts;
    }
    
    
    public int maxIndex(int arr[]){
        int max = Integer.MIN_VALUE;
        int maxInd = -1;
        int i, l = arr.length;
        for(i=0; i<l; i++)  {
            if(max < arr[i])    {
                   max = arr[i];
                   maxInd = i;
                }
            }
        return maxInd;
    }
    
    void simpleTests()  {
        
        FileResource fr = new FileResource();
        String contents = fr.asString();
        CaesarCipher2 cc = new CaesarCipher2(18);
        
        String encrypted = cc.encrypt(contents);
        System.out.println("encrypted is "+encrypted);
        /*System.out.println(cc.decrypt(encrypted));*/
        
        breakCaesarCipher(encrypted);
    }
    
    
    void breakCaesarCipher(String input) {
        CaesarBreaker cb = new CaesarBreaker();
        int key = cb.getKey(input);
        CaesarCipher2 cc = new CaesarCipher2(key);
        System.out.println(cc.decrypt(input));
    }
    
}
