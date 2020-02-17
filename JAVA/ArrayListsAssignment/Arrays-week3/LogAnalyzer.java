
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.lang.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
             LogEntry entry = WebLogParser.parseEntry(line);
             records.add(entry);
         }
     }
        
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIps(){
         List<String> l = new ArrayList<String>();
         for(LogEntry entry : records){
             String ip = entry.getIpAddress();
             if(!l.contains(ip))
                l.add(ip);
         }
         return l.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry entry : records){
             if(entry.getStatusCode() > num)
                System.out.println(entry);
         }
     }
     
     public List<String> uniqueIPVisitsOnDay(String someday){
         List<String> al = new ArrayList<String>();
         for(LogEntry entry : records){
             Date d = entry.getAccessTime();
             String ip = entry.getIpAddress();
             String str = d.toString();
             System.out.println(str);
             if(str.contains(someday) && (!al.contains(ip))){
                 al.add(ip);
             }
                
         }
         return al;
     }
     
     public int countUniqueIPsInRange(int low, int high){
         List<String> al = new ArrayList<String>();
         for(LogEntry entry : records){
             int status = entry.getStatusCode();
             
             if(status >= low && status <= high){
                 String ip = entry.getIpAddress();
                 if(!al.contains(ip))
                    al.add(ip);
                }
         }
         return al.size();
     }
     
    public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String, Integer> map = new HashMap<String, Integer>();
         for(LogEntry entry : records){
             String ip = entry.getIpAddress();
             int val = map.getOrDefault(ip, 0);
             map.put(ip, val+1);
         }
         return map;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> map){
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >(){
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                     return o2.getValue().compareTo(o1.getValue());
                }
         
        });
        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)list.iterator().next();
        return entry.getValue();
      
    }    
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map){
        ArrayList<String> al = new ArrayList<String>();
        int max = mostNumberVisitsByIP(map);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == max)
                al.add(entry.getKey());
                
       }
       return al;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();    
        for(LogEntry entry : records){
            Date d = entry.getAccessTime();
            String dates[] = d.toString().split("\\s");
            String date = dates[1]+" "+dates[2];
            ArrayList<String> al  = hm.getOrDefault(date, null);
            if(al == null){
                al= new ArrayList<String>();
                al.add(entry.getIpAddress());
                hm.put(date, al);
            }
            else
            {
                
                    al.add(entry.getIpAddress());
                    hm.put(date, al);
                
            } 
        }
        return hm;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> hm){
        int max = Integer.MIN_VALUE;
        String date = "";
        for(Map.Entry<String, ArrayList<String>> entry : hm.entrySet()){
                if(max < entry.getValue().size())
                 {
                     max = entry.getValue().size();
                     date = entry.getKey();
                 }
         }
                              
        return date;
        
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String date){
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> list = map.get(date);
        HashSet<String> set = new HashSet<String>(list);
        int max = Integer.MIN_VALUE;
        for(String str : set){
            int occ = Collections.frequency(list, str);
            if(max < occ)
                max = occ;
        }
        for(String str : set){
            if(Collections.frequency(list, str) == max) 
                al.add(str);
        }
        return al;
    }
}
