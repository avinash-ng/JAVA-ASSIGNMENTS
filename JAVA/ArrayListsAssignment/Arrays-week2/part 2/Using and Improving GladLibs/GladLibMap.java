import edu.duke.*;

import javax.swing.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> wordsHaveSeen;
    private Random myRandom;
    private ArrayList<String> wordsConsidered;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        
        wordsHaveSeen = new ArrayList<String>();
        myRandom = new Random();
        wordsConsidered = new ArrayList<String>();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        /*adjectiveList= readIt(source+"/adjective.txt");   
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source+"/verb.txt");
            fruitList = readIt(source+"/fruit.txt");*/
        String categories [] = new String[]{"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
        int i;
        for(i=0; i<9; i++)
        {   
            String h = categories[i];
            ArrayList<String> al = readIt(source+"/"+categories[i]+".txt");
            
            
            
            myMap.put(h, al);
            
            
        }

    }
    
    private String randomFrom(ArrayList<String> source){
       
        int index = myRandom.nextInt(source.size());
        
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        /*if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }

        if(label.equals("verb")){
            return randomFrom(verbList);
        }

        if(label.equals("fruit")){
            return randomFrom(fruitList);
        }

        return "**UNKNOWN**";*/
       
        if(label.equals("number"))
            return ""+myRandom.nextInt(50)+5;
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String word = w.substring(first+1,last);
        String sub = getSubstitute(word);
        if(!wordsConsidered.contains(word)) wordsConsidered.add(word);
        if(wordsHaveSeen.size() > 0){
            if( wordsHaveSeen.contains(sub)){
                sub = getSubstitute(w.substring(first+1, last));
            }
            else {
                wordsHaveSeen.add(sub);

            }
        }
        else
            wordsHaveSeen.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource("./"+source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    
    int totalWordsInMap()   {
        int count = 0;
        for(Map.Entry<String, ArrayList<String>> entry : myMap.entrySet())
        {
            count += entry.getValue().size();
        }
        return count;
    }
    
    int totalWordsConsidered(){
        int count = 0;
        for(String each : wordsConsidered){
            if(!each.equals("number"))
                count += myMap.get(each).size();
            else
                count += 1;
        }
        return count;
    }
    
    public void makeStory(){
        wordsHaveSeen.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        
        printOut(story, 60);
        System.out.println("words replaced are " +wordsHaveSeen.size());
    }
    

    public static void main(String args[]){
        GladLibMap g = new GladLibMap();
        g.makeStory();
        System.out.println("Total words are "+g.totalWordsInMap());
        System.out.println("Total words considered are "+g.totalWordsConsidered());
    }
}

