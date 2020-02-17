
/**
 * Write a description of class WordsInFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
import edu.duke.*;
public class WordsInFile
{
   private HashMap<String, ArrayList<String>> map;
   
   WordsInFile(){
       map = new HashMap<String, ArrayList<String>>();
   }
   
   public void addWordsFromFile(File f){
       FileResource fr = new FileResource(f);
       for(String word : fr.words())    {
           if(map.containsKey(word))
           {
               ArrayList<String> al = map.get(word);
               al.add(f.getName());
               map.put(word, al);
            }
            else
            {
                ArrayList<String> al = new ArrayList<String>();
                al.add(f.getName());
                map.put(word, al);
            }
        }
    }
    
    void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    int maxNumber(){
        int max = 0;
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if(max < entry.getValue().size()){
                max = entry.getValue().size();
            }
        }
        return max;
    }
    
    ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> al = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            int val = entry.getValue().size();
            if(val == number)
                al.add(entry.getKey());
        }
        return al;
    }
    
    void printFilesIn(String word){
        ArrayList<String> list = map.get(word);
        for(String each : list) {
            System.out.println(each);
        }
    }
    
    void tester(){
        buildWordFileMap();
        int max = maxNumber();
        System.out.println("Maximum num of files any word is in "+max);
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet())    {
            if(entry.getValue().size() == max)  {
                System.out.println("The word is "+entry.getKey());
                for(String value : entry.getValue())
                {
                    System.out.println(value);
                }
            }
        }
    }
    
}
