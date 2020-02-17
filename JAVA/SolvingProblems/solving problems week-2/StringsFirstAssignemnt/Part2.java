
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * 
2. Copy and paste the two methods findSimpleGene and testSimpleGene from the Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer with lowercase letters, the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
 */
public class Part2
{
    String findSimpleGene(String dna, String startCodon, String stopCodon){
         String upper ;
        if(!(dna.toUpperCase().equals(dna)))
            upper = dna.toUpperCase();
            
        else
            upper = dna;
        int ind1 = upper.indexOf(startCodon);
        if(ind1 == -1)
            return "";
        
        String dna_mod = upper.substring(ind1);
        int ind2 = dna_mod.indexOf(stopCodon);
        
        int len = (ind2+2) - (ind1+2);
        if(len%3==0)
            return dna.substring(ind1, ind2+3);
        else 
            return "";
            
    }
    
    void testSimpleGene(){
            String one = "atg";
            String two = "TAAATG";
            String three = "atctac";
            String four = "ATGATGATGTAATAATAA";
            String five = "ATG";
            System.out.println(findSimpleGene(one, "ATG", "TAA"));
            System.out.println(findSimpleGene(two, "ATG", "TAA"));
            System.out.println(findSimpleGene(three, "ATG", "TAA"));
            System.out.println(findSimpleGene(four, "ATG", "TAA"));
            System.out.println(findSimpleGene(five, "ATG", "TAA"));
        }
}
