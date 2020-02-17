
/**
 * Write a description of class CharacterNames here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay
{
    private ArrayList<String> myNames = new ArrayList<String>();
    private ArrayList<Integer> myFreqs = new ArrayList<Integer>();
    
    void update(String person){
        if(!myNames.contains(person)){
            
            myNames.add(person);
            myFreqs.add(1);
        }
        else
        {
            int ind = myNames.indexOf(person);
            int freq = myFreqs.get(ind) + 1;
            myFreqs.set(ind, freq);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            if(line.length() > 0)
            {
                int ind = line.indexOf(".");
                if(ind != -1)
                {
                    String speaker = line.substring(0, ind);
                    if(myNames.contains(speaker)){
                        int ind_spek = myNames.indexOf(speaker);
                        myFreqs.set(ind_spek, myFreqs.get(ind_spek)+1);
                    }
                    else{
                        myNames.add(speaker);
                        myFreqs.add(1);
                    }
                }
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        for(int i=0; i<myNames.size(); i++){
            System.out.println(myNames.get(i)+" "+myFreqs.get(i));
        }
        charactersWithNumParts(1, 5);
    }
    
    void charactersWithNumParts(int num1, int num2){
        if(num1 <= num2){
            for(int i=0; i<myNames.size(); i++){
                int number = myFreqs.get(i);
                if( number >= num1 && number < num2){
                    System.out.println(myNames.get(i));
                }
            }
            
        }
    }
}
