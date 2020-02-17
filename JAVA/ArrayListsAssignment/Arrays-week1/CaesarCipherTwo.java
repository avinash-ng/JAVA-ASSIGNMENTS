
/**
 * Write a description of class CaesarCipherTwoKeys here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    
    CaesarCipherTwo(int key1, int key2) {
        this.key1 = key1;
        this.key2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0, key2);
    }
    
    String encrypt(String input)   {
        int i, l = input.length();
        input = input.toUpperCase();
        String output = "";
        for(i=0; i<l; i++)  {
            if(i%2 == 0)    {
                int ind = (int)(input.charAt(i))%65;
                output += String.valueOf(shiftedAlphabet1.charAt(ind));
            }
            else    {
                int ind1 = (int)(input.charAt(i))%65;
                output += String.valueOf(shiftedAlphabet2.charAt(ind1));
            }
        }
        return output;
    }
    
    String decrypt(String input)   {
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26-key1, 26-key2);
        return cc2.encrypt(input);
    }
    
}

