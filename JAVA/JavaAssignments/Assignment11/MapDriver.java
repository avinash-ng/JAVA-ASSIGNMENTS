/**
    * Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument and counts the occurrence of all the different characters. Save the results in a text file.

 */
import java.util.*;
import java.io.*;
class MapDriver
{
   
    static HashMap<String, Integer> mapper = new HashMap<String, Integer>();
    static FileReader inputReader ;
    static FileWriter outputWriter;
    
    static void buildMap(String fileName) throws Exception{
        inputReader = new FileReader(fileName);
        outputWriter = new FileWriter("output-"+fileName);
        int charAsInt;
        while((charAsInt = inputReader.read()) != -1)  {
               char character = (char)charAsInt;
               String key= "";
               if(character == '\n')
                  key = "\\n";
               else if(character == '\t')
                  key = "\\t";
               else if(character == '\r')
                  key = "\\r";
            
               else
                  key = String.valueOf(character);


               int count = mapper.getOrDefault(key, 0);
               mapper.put(key, count+1);
         }
    }
    
    public static void main(String args[])
    {
        try
        {
            buildMap(args[0]);
            for(Map.Entry<String, Integer> entry : mapper.entrySet()){
                outputWriter.write("The character "+entry.getKey()+" appeared exactly "+entry.getValue()+" times ");
                outputWriter.write("\n");
            }
            outputWriter.close();
         }
        catch (Exception ex){};

    }
}
