
/**
 * Write a description of class TestCeaserCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCeaserCipherTwo
{
    String halfOfString(String message, int start) {
        String ans = "";
        int i, l= message.length();
        for(i=start; i<l; i+=2) {
            ans += String.valueOf(message.charAt(i));
        }
        return ans;
    }
    
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
        System.out.println(contents);
        System.out.println(contents.length());
        CaesarCipherTwo cc2 = new CaesarCipherTwo(17, 3);
        String encrypted = cc2.encrypt(contents);
        System.out.println("encrypted is "+encrypted);
        System.out.println(cc2.decrypt(encrypted));
        
    }
    

}
