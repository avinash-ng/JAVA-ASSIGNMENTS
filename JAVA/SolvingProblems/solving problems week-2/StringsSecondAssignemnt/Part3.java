
/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
Copy your methods from Part1 to find one gene and print all genes.

3. Write the method named countGenes that has a String parameter named dna representing a string of DNA. This method returns the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG. Hint: This is very similar to finding all genes and printing them, except that instead of printing all the genes you will count them.

4. Write the void method named testCountGenes that has no parameters. This method calls countGenes with many example strings and prints the result for each. You should create several examples with different numbers of genes to test your code.
 */
import java.util.*;
public class Part3
{
    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1)  {
            int diff = currIndex-startIndex;
            if(diff%3==0)
                return currIndex;
            else    {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    String findGene(String dna)    {
        String startCodon = "ATG";
        int ind1 = dna.indexOf(startCodon);
        if(ind1 == -1)
            return "";
        
        String stopCodon = "TAA";
        int ind2 = findStopCodon(dna, ind1, stopCodon);
        
        String stopCodon1 = "TAG";
        int ind3 = findStopCodon(dna, ind1, stopCodon1);
        
        String stopCodon2 = "TGA";
        int ind4 = findStopCodon(dna, ind1, stopCodon2);
        
        int diff21 = ind2-ind1;
        int diff31 = ind3-ind1;
        int diff41 = ind4-ind1;
        
        if(diff21 < diff31 && diff21 < diff41)
            return stopCodon;
        else if(diff31 < diff21 && diff31 < diff41)
            return stopCodon1;
        else
            return stopCodon2;
        
    }  
    
    void printAllGenes(String dna)  {
        int startIndex = 0;
        while(true) {
            if(dna.length() == 3)
                break;
            String gene = findGene(dna);
            if(gene.isEmpty())
                break;
            else
            {
                  int ind = dna.indexOf("ATG");
                  System.out.println(gene);
                  dna = dna.substring(dna.indexOf(gene)+gene.length());
                  
                 
                  
            }
        }
    }
    
    int countGenes(String dna)  {
        int startIndex = 0;
        ArrayList<String> list = new ArrayList<String>();
        
        while(true) {
            if(dna.length() == 3)
                break;
            String gene = findGene(dna);
            if(gene.isEmpty())
                break;
            else
            {
                  int ind = dna.indexOf("ATG");
                  if(!list.contains(gene))
                        list.add(gene);
                  dna = dna.substring(dna.indexOf(gene)+gene.length());
                  
                 
                  
            }
        }
        return list.size();
    }
    
    void testCountGenes()   {
        int count1 = countGenes("ATGTAAGATGCCCTAGT");
        if(count1 != 2) System.out.println("error it should be 2");
        
        System.out.println("tests finished");
    }
    
}
