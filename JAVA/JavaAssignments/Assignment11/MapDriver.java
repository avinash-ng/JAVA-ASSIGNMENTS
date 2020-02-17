/**
    * Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument and counts the occurrence of all the different characters. Save the results in a text file.

 */
import java.util.*;
import java.io.*;
class MapDriver
{
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static FileReader in ;
    static FileWriter output;
    static void builtMap(String fileName) throws Exception{
        in = new FileReader(fileName);
        output = new FileWriter("output-"+fileName);

        int c;
        while((c=in.read()) != -1)  {
            char ch = (char)c;
            String key = "";
            if(ch == '\n')
                key = "\\n";
            else if(ch == '\t')
                key = "\\t";
            else if(ch == '\r')
                key = "\\r";
            
            else
                key = String.valueOf(ch);


            int count = map.getOrDefault(key, 0);
            map.put(key, count+1);
        }
    }
    public static void main(String args[])
    {

       try
       {
           builtMap(args[0]);
           for(Map.Entry<String, Integer> entry : map.entrySet()){
               output.write("The character "+entry.getKey()+" appeared exactly "+entry.getValue()+" times ");
               output.write("\n");
           }
           output.close();
       }
       catch (Exception ex){};

    }
}