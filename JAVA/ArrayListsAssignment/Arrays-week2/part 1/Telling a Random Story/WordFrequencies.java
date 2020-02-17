
/**
 * Write a description of class WordFrequencies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        String message[] = fr.asString().split("\\s");
        for(String word : message){
            if((myWords.size() == 0) || (!myWords.contains(word)))
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else if(myWords.contains(word)){
                int ind = myWords.indexOf(word);
                int count = myFreqs.get(ind)+1;
                myFreqs.set(ind, count);
            }
        }
    }
    
    void tester(){
        findUnique();
        for(int i=0; i<myWords.size(); i++){
            System.out.println(myFreqs.get(i)+"\t"+ myWords.get(i));
        }
        System.out.println("The word that occurs most often and its count are:"+myWords.get(findIndexOfMax())+" "+myFreqs.get(findIndexOfMax()));
    }
    
    
    public int findIndexOfMax(){
        int max_freq = Collections.max(myFreqs);
        return myFreqs.indexOf(max_freq);
        
    }
}