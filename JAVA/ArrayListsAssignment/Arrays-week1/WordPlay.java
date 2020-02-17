
/**
 * Write a description of class Assignment1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    public static boolean isVowel(char ch){
        if(ch=='a' || ch =='A' || ch =='e' || ch=='E' ||ch == 'i' ||ch=='I' || ch=='o' || ch=='O' ||ch=='u' || ch=='U')
            return true;
        return false;
    }
    
    
    public static String replaceVowels(String phrase, char ch){
        String s ="";
        int i=0, len = phrase.length();
        for(; i<len; i++){
            if(isVowel(phrase.charAt(i)))
                s += String.valueOf(ch);
            else
                s += String.valueOf(phrase.charAt(i));
        }
        return s;
    }
    
    public static String emphasize(String phrase, char ch){
        int i, l=phrase.length();
        String s="";
        for(i=1; i<=l; i++){
            if(i%2 == 1 && phrase.charAt(i-1)==ch)
                s += String.valueOf('*');
            else if(phrase.charAt(i-1)==ch)
                s += String.valueOf('+');
            else
                s += String.valueOf(phrase.charAt(i-1));
             
        }
        return s;
    }
}
