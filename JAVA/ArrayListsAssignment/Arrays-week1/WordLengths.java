
/**
 * Write a description of class WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths
{
    public void countWordLengths(FileResource resource, int counts[]){
        for (String word : resource.words()) {
            int i, l = word.length();
            int count = 0;
            for (i=0; i<l; i++){
                if(Character.isLetter(word.charAt(i)) || word.charAt(i) == '\'')
                    count += 1;
                if((word.charAt(i) == '\"' || word.charAt(i) == '-') && count == 0)
                    continue;
                else if((word.charAt(i) == '\"' || word.charAt(i) == '-') && count != 0)
                    break;               
            }
            counts[count] += 1;
        }
    }
    
    void testCountWordLengths(){
        FileResource fr = new FileResource();
        int count[] = new int[32];
        countWordLengths(fr, count);
        System.out.println(indexOfMax(count));
        for (int i=1; i<=31; i++)   {
            System.out.println(count[i]);
        }
    }
    
    int indexOfMax(int values[]){
        int max = Integer.MIN_VALUE;
        int max_index=-1;
        for(int i=0; i<values.length; i++) {
            if( values[i] > max ){
                max = values[i];
                max_index = i;
            }
        }
        return max_index;
    }
}
