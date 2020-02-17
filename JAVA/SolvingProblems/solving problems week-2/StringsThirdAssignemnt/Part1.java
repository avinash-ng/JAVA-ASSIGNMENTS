

/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * 
1. Create a new Java project named StringsThirdAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. Copy and paste the code from your Part1 class in your StringsSecondAssignments project into this class.

3. Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found, this method should create and return a StorageResource containing the genes found. Remember to import the edu.duke libraries otherwise you will get an error message cannot find the class StorageResource.

4. Make sure you test your getAllGenes method.

Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.

Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna.

Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them. Specifically, it should:

print all the Strings in sr that are longer than 9 characters
print the number of Strings in sr that are longer than 9 characters
print the Strings in sr whose C-G-ratio is higher than 0.35
print the number of strings in sr whose C-G-ratio is higher than 0.35
print the length of the longest gene in sr
Write a method testProcessGenes. This method will call your processGenes method on different test cases. Think of five DNA strings to use as test cases. These should include: one DNA string that has some genes longer than 9 characters, one DNA string that has no genes longer than 9 characters, one DNA string that has some genes whose C-G-ratio is higher than 0.35, and one DNA string that has some genes whose C-G-ratio is lower than 0.35. Write code in testProcessGenes to call processGenes five times with StorageResources made from each of your five DNA string test cases.

Modify your processGenes method so that it prints all the Strings that are longer than 60 characters and prints the number of Strings that are longer than 60 characters (you do not need to make changes to the rest of the method).

Modify the method testProcessGenes to call processGenes with a StorageResource of the genes found in the file brca1line.fa.
 */
import edu.duke.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class Part1
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
            return dna.substring(ind1, ind2+3);
        else if(diff31 < diff21 && diff31 < diff41)
            return dna.substring(ind1, ind3+3);
        else
            return dna.substring(ind1, ind4+3);
        
    }  
        
        
        
    void testFindStopCodon() {
        String dna = "AGTGATTCGGCTCTGTAA";
        int dex = findStopCodon(dna, -1, "TAA");
        System.out.println(dex);
        
        System.out.println("tests finished");
    }
    
    void testFindGene(){
        String dna1 = "AAATGCCCTGACTAGATTAAGAAACC";
        String dna2 = "ATGTAA";
        String dna3 = "AGTCCGTAGATCGAC";
        String dna4 = "ATGAAT";
        String dna5 = "ATAATAAAGTG";
        
        System.out.println(dna1);
        System.out.println(findGene(dna1));
        
        System.out.println(dna2);
        System.out.println(findGene(dna2));
        
        System.out.println(dna3);
        System.out.println(findGene(dna3));
        
        System.out.println(dna4);
        System.out.println(findGene(dna4));
        
        System.out.println(dna5);
        System.out.println(findGene(dna5));
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
    
    StorageResource getAllGenes(String dna)  {
        StorageResource sr = new StorageResource();
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
                  sr.add(gene);
                  dna = dna.substring(dna.indexOf(gene)+gene.length());
                  
                 
                  
            }
        }
        return sr;
    }
    
    void testGetAllGenes()  {
        StorageResource sr = getAllGenes("ATGTAAGATGCCCTAGT");
        if(sr.size() == 2 && sr.contains("ATGTAA") && sr.contains("ATGCCCTAG"))
            System.out.println("tests passed");
        else
            System.out.println("tests failed");
    }
    
    
    float cgRatio(String dna)    {
        int i, l= dna.length();
        int count=0;
        for(i=0; i<l; i++)  {
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G')
                count += 1;
    
            }
            return count/(float)l;
    }
    
    int countCTG(String dna)    {
        Pattern p = Pattern.compile("CTG");
        Matcher obj = p.matcher(dna);
        int count=0;
        while(obj.find())
            count += 1;
        return count;
    }
    
    void processGenes(StorageResource sr) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        String ans = "";
        int max = 0;
        for(String rec : sr.data()) {
            
            if(cgRatio(rec) > 0.35)
                list2.add(rec);
            if(rec.length() > 9)
                list1.add(rec);
                
            if(rec.length() > 60)
                list3.add(rec);
                
            if(max < rec.length())
            {
                max = rec.length();
                ans = rec;
            }
        }
        System.out.println("Strings that are longer than 9 characters");
        for(String str : list1){
            System.out.println(str);
        }
        
        System.out.println("Num of strings longer than 9 are "+list1.size());
        
        System.out.println("Strings that are having cg ratio > 0.35");
        for(String str : list2){
            System.out.println(str);
        }
        
        System.out.println("Num of strings having cg ratio > 0.35 are "+list1.size());
        
        System.out.println("Length of longest gene in sr "+max);
        
        System.out.println("Strings that are longer than 60 characters");
        for(String str : list3){
            System.out.println(str);
        }
        
        System.out.println("Num of strings longer than 60 are "+list3.size());

    }
       
    void testProcessGenes() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
    }
}


