import java.util.*;
import edu.duke.*;
import java.io.File;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        int i, l= message.length();
        StringBuilder slice = new StringBuilder();
        for (i=whichSlice; i<l; i+=totalSlices) {
            slice.append(message.charAt(i));
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i=0; i<klength; i+=1){
            String s = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(s);
        }
        
        return key;
    }

    char mostCommonCharIn(HashSet<String> dictionary){
        int occurences[] = new int[26];
        int i, max = Integer.MIN_VALUE;
        char ans = ' ';
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(String each : dictionary){
            int  l = each.length();
            for(i=0; i<l; i++)  {
                
                int val = hm.getOrDefault(each.charAt(i), 0);
                hm.put(each.charAt(i), val+1);
                if(max < val+1){
                    max = val+1;
                    ans = each.charAt(i);
                }
            }
            }
            return ans;
        }
    
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> hset = new HashSet<String>();
        for(String line : fr.lines()){
            hset.add(line.toLowerCase());
        }
        return hset;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        String array[] = message.split("\\w+");
        int count = 0;
        for(String each : array){
            if(dictionary.contains(each.toLowerCase()))
                count += 1;
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int i, max = Integer.MIN_VALUE;
        String string = "";
        for(i=0; i<100; i++){
            char common = mostCommonCharIn(dictionary);
            int key[] = tryKeyLength(encrypted, i+1, common);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int val = countWords(decrypted, dictionary);
            if(max < val){
                max = val;
                string = decrypted;
            }
        }
        return string;
        
    }
    public String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages)  {
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(Map.Entry<String, HashSet<String>> entry : languages.entrySet()){
            HashSet<String> hset = entry.getValue();
            String lang = entry.getKey();
            String message = breakForLanguage(encrypted, hset);
            int words = countWords(message, hset);
            if(words > max){
                max = words;
                ans = message;
            }
        }
        return ans;
        
    }
    
    
    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        int i;
        HashMap<String, HashSet<String>> hmap = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            String name = f.getName();
            FileResource fr = new FileResource(f);
            String content = fr.asString();
            HashSet<String> hset = readDictionary(fr);
            hmap.put(name, hset);
        }
        
        
        FileResource fr = new FileResource();
        String content = fr.asString();
        int arr[] = tryKeyLength(content, 5, 'e');
        System.out.println(arr[0] +" "+ arr[1] +" "+ arr[2] +" "+ arr[3] +" "+ arr[4]);
        HashSet<String> hset = readDictionary(fr);
        
        VigenereCipher vc = new VigenereCipher(arr);
        String encrypted = vc.decrypt(content);
        System.out.println("Encrypted message is "+encrypted);
        System.out.println(breakForAllLangs(encrypted, hmap));
        
        }
    }
    
   

