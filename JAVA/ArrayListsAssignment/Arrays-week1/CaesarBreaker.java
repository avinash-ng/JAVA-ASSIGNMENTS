
/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class CaesarBreaker
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
    
    public String decrypt(String encrypted) {
        CeaserCipher obj = new CeaserCipher();
        int freq[] = countLetters(encrypted);
        int ind = maxIndex(freq);
        int key = ind-4;
        if(ind < 4) {
            key = 26 - (4-ind);
        }
        String decrypted = obj.encrypt(encrypted, 26-key);
        return decrypted;
    }
    
    public void testDecrypt()   {
        CeaserCipher obj = new CeaserCipher();
        String message = "feed me more";
        System.out.println("Message "+ message);
        String encrypted = obj.encrypt(message, 5);
        System.out.println("Encrypted "+encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted "+decrypted);
    }
    
    int getKey(String s) {
        int arr[] = countLetters(s);
        int ind = maxIndex(arr);
        int key = ind-0;
        if(ind < 0) {
            key = 26 - (0-ind);
        }
        return key;
    }
    
    
    String decryptTwoKeys(String encrypted){
        CeaserCipher obj = new CeaserCipher();
        String firstPart = halfOfString(encrypted, 0);
        String secondPart = halfOfString(encrypted, 1);
        int key1 = getKey(firstPart);
        
        int key2 = getKey(secondPart);
        System.out.println("Key 1 "+key1+" Key 2 "+key2);
        return obj.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }
    
}
