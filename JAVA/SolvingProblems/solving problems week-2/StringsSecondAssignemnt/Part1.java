
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * 
 * 
 * 
 * 2. Create a new Java Class named Part1. The following methods go in this class.

3. Write the method findStopCodon that has three parameters, a String parameter named dna, an integer parameter named startIndex that represents where the first occurrence of ATG occurs in dna, and a String parameter named stopCodon. This method returns the index of the first occurrence of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns the length of the dna strand.

4. Write the void method testFindStopCodon that calls the method findStopCodon with several examples and prints out the results to check if findStopCodon is working correctly. Think about what types of examples you should check. For example, you may want to check some strings of DNA that have genes and some that do not. What other examples should you check?

5. Write the method findGene that has one String parameter dna, representing a string of DNA. In this method you should do the following:

Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.
Find the index of the first occurrence of the stop codon “TAG” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Find the index of the first occurrence of the stop codon “TGA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”.
Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away. If there is no valid stop codon and therefore no gene, return the empty string.
6. Write the void method testFindGene that has no parameters. You should create five DNA strings. The strings should have specific test cases such as DNA with no “ATG”, DNA with “ATG” and one valid stop codon, DNA with “ATG” and multiple valid stop codons, DNA with “ATG” and no valid stop codons. Think carefully about what would be good examples to test. For each DNA string you should:

Print the DNA string.
Calculate the gene by sending this DNA string as an argument to findGene. If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.
7. Write the void method printAllGenes that has one String parameter dna, representing a string of DNA. In this method you should repeatedly find genes and print each one until there are no more genes. Hint: remember you learned a while(true) loop and break.


 */
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
}


