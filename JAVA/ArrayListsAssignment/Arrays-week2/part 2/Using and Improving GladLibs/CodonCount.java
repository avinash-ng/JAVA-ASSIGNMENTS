
/**
 * Write a description of class CodonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CodonCount
{
    private HashMap<String, Integer> map ;
    
    public CodonCount(){
        map = new HashMap<String, Integer>();
    }
    
    void buildCodonMap(int start, String dna){
        int i, l = dna.length();
        for(i=start; i<l; ){
            if(i+3 < l)
            {
                String codon = dna.substring(i, i+3);
                int count = map.getOrDefault(codon, 0);
                map.put(codon, count+1);
                i = i+codon.length();
            }
            else
                break;
        }
    }
    
    String getMostCommonCodon(){
        int max = 0;
        String ans ="";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            String key = entry.getKey();
            
            if(val > max){
                max = val;
                ans = key;
            }
        }
        return ans;
    }
    
    
    void printCodonCounts(int start, int end)    {
        for(Map.Entry<String, Integer> entry : map.entrySet())  {
            int val = entry.getValue();
            String key = entry.getKey();
            
            if(val >= start && val <= end)
                System.out.println("codon "+key+" has count "+val);
        }
    }
    
    
    void test(){
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();
        
        for(int i=0; i<=2; i++){
            System.out.println((i+1)+" iteration");
            buildCodonMap(i, dna);
            int unique = map.size();
            System.out.println("unique codons are "+ unique);
            String common = getMostCommonCodon();
            int count = map.get(common);
            System.out.println("most common codon is "+common+ "ansd its count is "+count);
            printCodonCounts(1, 5);
            map.clear();
        }
    }
}
    

