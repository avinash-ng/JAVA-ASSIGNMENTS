/**
 * Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
 * Use the system ping utility, do not use any deprecated methods.
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PingDriver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // String command = br.readLine();
        List<String> list = new ArrayList<String>();
        list.add("ping");
        list.add("-c");
        list.add("10");
        list.add("google.com");
        List<Double> l = new ArrayList<Double>();
        ProcessBuilder pb = new ProcessBuilder(list);
        pb.directory(new File("/home"));
        try {
            Process p = pb.start();
            BufferedReader ans = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while (true) {
                try {
                    if ((line = ans.readLine()) == null) break;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(line.contains("time=")){
                    int start_ind = line.indexOf("time=")+5;
                    int end_ind = line.indexOf("ms");
                    l.add(Double.parseDouble(line.substring(start_ind, end_ind).strip()));
                }
            }

            try {
                ans.close();

                Collections.sort(l);
                System.out.println("Median is " + ((l.get(4)+l.get(5))/2));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        catch(IOException ex){
        ex.printStackTrace();
    }
    }
}
