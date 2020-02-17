/**
 * Create a java program to search through the home directory and look for files that match a regular expression.
 *  The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
 *  Provide appropriate documentation and comments on your code.
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindDriver {
    public static void main(String args[]) throws IOException {


        String ans = "abcdefghi def ghi";
        for(String a : ans.split("ef"))
            System.out.println(a);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
//command to be executed is fed into a list
        List<String> list = new ArrayList<String>();
        list.add("find");
        list.add(".");
        list.add("-name");
        list.add(input);

        ProcessBuilder pb = new ProcessBuilder(list);

//setting directory to be looked for
        pb.directory(new File("/home"));


        try{
//executing the command inside list
            Process p = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            while (true) {
//iterating the output of the executed command

                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(line);
            }

            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        catch(IOException ex){
            System.out.println("Exception raised");
        }
    }
}
