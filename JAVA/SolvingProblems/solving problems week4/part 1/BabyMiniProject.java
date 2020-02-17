
/**
 * Write a description of class BabyMiniProject here.
 *
 * @author (Avinash)
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BabyMiniProject
{
    
    static Map<Integer, CSVRecord> map;
    public static CSVParser getParser(int year){
        
        FileResource fr = new FileResource(String.format("us_babynames_small/testing/yob"+year+"short.csv"));
        CSVParser parser = fr.getCSVParser(false);
        return parser;
    }
    
    public static void totalBirths(int year){
            int males =0, females=0;
           
            CSVParser parser = getParser(year);
            for(CSVRecord rec : parser)
            {
                String s = rec.get(1);
                System.out.println(rec.get(0)+" "+s+" "+rec.get(2));
                
                if(s=="M") males++;
                else females++;
          
            }
            System.out.println("Females: "+females+" Males: "+males+" Total: "+(males+females));
    }
    
    public static Comparator<CSVRecord> createComparator(){
        Comparator<CSVRecord> comp = new Comparator<CSVRecord>(){
            public int compare(CSVRecord r1, CSVRecord r2){
                return Integer.valueOf(r2.get(2)).compareTo(Integer.valueOf(r1.get(2)));
            }
        };
        return comp;
    }
    
    public static void addToHashMap(int rank, CSVRecord rec){
        map.put(rank, rec);
    }
    
    
    public static int giveRankings(List<CSVRecord> list){
        map = new HashMap<Integer, CSVRecord>();
        
        
        int rank = 1;
        for(CSVRecord rec : list){
           
                addToHashMap(rank, rec);
            
                rank += 1;
        }
        return rank-1;
    }
    
    
    public static int getRank(int year, String name, String gender){
        
        
        
        CSVParser parser = getParser(year);
        List<CSVRecord> list = new ArrayList<CSVRecord>();
        for(CSVRecord rec : parser){
            if(rec.get(1).equals(gender))
            {
                list.add(rec);
                
            }
        }
        
        Collections.sort(list, createComparator());
        int lastRank = giveRankings(list);
        
        for(int i=1; i<=lastRank; i++)
        {
            CSVRecord l = map.get(i);
            
            if(l.get(0).equals(name))
                 
                return i;
            }
        map.clear();
        return -1;
    }
    
    public static String getName(int year, int rank, String gender){
       
        CSVParser parser = getParser(year);
        CSVRecord f = null;
        
        List<CSVRecord> l = new ArrayList<CSVRecord>();
        for(CSVRecord rec : parser)  {if(rec.get(1).equals(gender)) l.add(rec);}
        int lastRank = giveRankings(l);
        
        if(rank > lastRank || rank < 1) return "NO NAME";
        else{
           CSVRecord list = map.get(rank);
           
           
           return list.get(0);
        }
        
    }
    
    
    
    static void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rankOfName = getRank(year, name, gender);
        
        
        CSVParser parser1 = getParser(newYear);
        List <CSVRecord> list2 = new ArrayList<CSVRecord>();
        for(CSVRecord rec1 : parser1){
            if(rec1.get(1).equals(gender))
                list2.add(rec1);
        }
        
        Collections.sort(list2, createComparator());
        
        int lastRank2 = giveRankings(list2);

        CSVRecord rec2 = map.get(rankOfName);
        System.out.println(name+" born in "+year+" would be "+rec2.get(0)+" if she was born in "+newYear);;
        map.clear();
    }
    
    public static int yearOfHighestRank(String name, String gender){
        int year1 = 2012;
        int year2 = year1+1;
        int year3 = year2+1; 
        
        
        int r1 = getRank(year1, name, gender);
        map.clear();
        
        
        int r2 = getRank(year2, name, gender);
        map.clear();
        
        int r3 = getRank(year3, name, gender);
        map.clear();
        
        
        if(r1 == -1 && r2 == -1 && r3 == -1)
            return -1;
            
        if(r1 < r2 && r1 < r3)
            return year1;
        else if(r2 < r1 && r2 < r3)
            return year2;
        else
            return year3;
        
    }
    
    public static double getAverageRank(String name, String gender){
        int year1 = 2012;
        int year2 = year1+1;
        int year3 = year2+1;
        
        int r1 = getRank(year1, name, gender);
        int r2 = getRank(year2, name, gender);
        int r3 = getRank(year3, name, gender);
        
        if(r1 == -1 && r2 == -1 && r3 == -1)
            return -1.0D;
        else
            return (r1+r2+r3)/3.0D;
        
    }
    
    
    public static int getTotalBirthsRankedHigher(int year, String name, String gender){
        int rank = getRank(year, name, gender);
        int i, sum=0;
        for(i=1; i<rank; i++)
        {
            CSVRecord rec = map.get(i);
            sum += Integer.parseInt(rec.get(2));
        }
        map.clear();
        return sum;
    }
    
    
    
    public static void main(String args[]) {
       
    
       
        System.out.println(getRank(2012, "Mason", "F"));
        System.out.println(getName(2012, 2, "M"));
        whatIsNameInYear("Isabella", 2012, 2014, "F");
        System.out.println(yearOfHighestRank("Mason", "M"));
        System.out.println(getAverageRank("Jacob", "M"));
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    
    }
}
