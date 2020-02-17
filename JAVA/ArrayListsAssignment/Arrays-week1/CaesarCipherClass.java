
/**
 * Write a description of class CaesaeCipher2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherClass
{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    CaesarCipher2(int key)   {
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRTSUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0, key);
    }
    
    public String encrypt(String input)    {
        String output = "";
        input = input.toUpperCase();
        
        for(int i=0; i<input.length(); i++) {
            int ch = ((int)input.charAt(i))%65;
            if(Character.isLetter(input.charAt(i)))
                output += String.valueOf(shiftedAlphabet.charAt(ch));
            else
                output += String.valueOf(input.charAt(i));
        }
        return output;
    }
    
    String decrypt(String input)   {
        CaesarCipher2 cc = new CaesarCipher2(26-mainKey);
        return cc.encrypt(input);
        
    }
}
