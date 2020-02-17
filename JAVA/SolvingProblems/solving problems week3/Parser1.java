
/**
 * Write a description of class Parser1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
Write a method named tester that will create your CSVParser and call each of the methods below in parts 2, 3, 4, and 5. You would start your code with:
 
2. Write a method named countryInfo that has two parameters, parser is a CSVParser and country is a String. This method returns a string of information about the country or returns “NOT FOUND” if there is no information about the country. The format of the string returned is the country, followed by “: “, followed by a list of the countries’ exports, followed by “: “, followed by the countries export value.
 
3. Write a void method named listExportersTwoProducts that has three parameters, parser is a CSVParser, exportItem1 is a String and exportItem2 is a String. This method prints the names of all the countries that have both exportItem1 and exportItem2 as export items.

4. Write a method named numberOfExporters, which has two parameters, parser is a CSVParser, and exportItem is a String. This method returns the number of countries that export exportItem. For example, using the file exports_small.csv, this method called with the item “gold” would return 3.

5. Write a void method named bigExporters that has two parameters, parser is a CSVParser, and amount is a String in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a string might be “$400,000,000”. This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string. You do not need to parse either string value as an integer, just compare the lengths of the strings.
*/

/**
1. Write a method named coldestHourInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. You should also write a void method named testColdestHourInFile() to test this method and print out information about that coldest temperature, such as the time of its occurrence.

2. Write the method fileWithColdestTemperature that has no parameters. This method should return a string that is the name of the file from selected files that has the coldest temperature. You should also write a void method named testFileWithColdestTemperature() to test this method. Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day. 
 
3. Write a method named lowestHumidityInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.

4. Write the method lowestHumidityInManyFiles that has no parameters. This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. You should also write a void method named testLowestHumidityInManyFiles() to test this method and to print the lowest humidity AND the time the lowest humidity occurred. Be sure to test this method on two files so you can check if it is working correctly.

5. Write the method averageTemperatureInFile that has one parameter, a CSVParser named parser. This method returns a double that represents the average temperature in the file. You should also write a void method named testAverageTemperatureInFile() to test this method.

6. Write the method averageTemperatureWithHighHumidityInFile that has two parameters, a CSVParser named parser and an integer named value. This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. You should also write a void method named testAverageTemperatureWithHighHumidityInFile() to test this method.
*/
import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class Parser1
{
    public CSVParser tester(FileResource fr){
        return fr.getCSVParser();
    }
    
    public String CountryInfo(CSVParser p, String country){
        for(CSVRecord record : p){
            if(record.get("Country").equals(country))
                return country+": "+record.get("Exports")+": "+record.get("Value (dollars)");
        }
        return "NOT FOUND";
        
    }
    
    public void listExportersTwoProducts(CSVParser p, String item1, String item2){
        for(CSVRecord rec : p)
        {
            String s = rec.get("Exports");
            if(s.contains(item1) && s.contains(item2))
                System.out.println(rec.get("Country"));
            
            
        }
    }
    
    public int numberOfExporters(CSVParser p, String item)
    {
        int count = 0;
        for(CSVRecord rec : p){
            if(rec.get("Exports").contains(item)) count++;
        }
        return count;
    }
    
    public void bigExporters(CSVParser p, String amount){
        for(CSVRecord rec : p){
            
            String amnt = rec.get("Value (dollars)");
            String amnt1 = amount.substring(1, amount.length());
            String country = rec.get("Country"); 
           
            String amnt2 = amnt.replaceAll("[,$]" , "");
            if(Long.parseLong(amnt2) > Long.parseLong(amnt1))
                System.out.println(country+" "+amnt);
           
        }
    
    }
    
    CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord r=null;
        float f = Float.MAX_VALUE;
        for(CSVRecord rec : parser){
            float f1 = Float.parseFloat(rec.get("TemperatureF"));
            if(f1 < f && f1 < 1000 && f1 > -1000){
                f = f1;
                r = rec;
            }
            
        }
        return r;
    }
    
    void testColdestHourInFile(){
        FileResource fr = new FileResource();
        Parser1 parser = new Parser1();
        CSVRecord rec = parser.coldestHourInFile(parser.tester(fr));
        System.out.println(rec);
    }
    
    String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        float temp = Float.MAX_VALUE; 
        String str= "";
        for(File f : dr.selectedFiles()){
            
            CSVRecord csv = coldestHourInFile(tester(new FileResource(f)));
            if(temp > Float.parseFloat(csv.get("TemperatureF")))
            {
                temp = Float.parseFloat(csv.get("TemperatureF"));
                str = f.getName();
            }
            
        }
        return str;
    }
    
    void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
        System.out.println("Coldest day was in file "+fileName);
        File f = new File("/home/kolaparthi/Downloads/nc_weather/2014/"+fileName);
        FileResource fr = new FileResource(f);
        CSVRecord csv = coldestHourInFile(tester(fr));
        System.out.println("Coldest temperature on that day was "+csv.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were ");
        for(CSVRecord rec : tester(fr)){
            System.out.println(rec.get("DateUTC")+" "+rec.get("TimeEST")+" "+rec.get("TemperatureF"));
        }
    }
    
    CSVRecord lowestHumidityInFile(CSVParser parser){
        float humid = Float.MAX_VALUE;
        CSVRecord r = null;
        for(CSVRecord rec : parser){
            String humd = rec.get("Humidity");
            if(!humd.equals("N/A")){
                float f1 = Float.parseFloat(humd);
                if(f1 < humid){
                    humid = f1;
                    r = rec;
                }
            }
        }
        return r;
    }
    
    void testLowestHumidityInFile()  {
        FileResource fr = new FileResource();
        CSVParser parser = tester(fr);
        CSVRecord rec = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+rec.get("Humidity")+" at "+rec.get("DateUTC")+" "+rec.get("TimeEST"));
    }
    
    CSVRecord lowestHumidityInManyFiles()
    {
        DirectoryResource dr = new DirectoryResource();
        float min = Float.MAX_VALUE;
        CSVRecord csv = null;
        for(File f : dr.selectedFiles()){
            CSVRecord rec = lowestHumidityInFile(tester(new FileResource(f)));
            float h = Float.parseFloat(rec.get("Humidity"));
            if(h < min){
                min = h;
                csv = rec;
            }
        }
        return csv;
    }
    
    void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC")+" "+csv.get("TimeEST"));
    }
    
    double averageTemperatureInFile(CSVParser parser){
        float avgT = 0F;
        int count = 0;
        for(CSVRecord rec : parser){
            avgT += Float.parseFloat(rec.get("TemperatureF"));
            count += 1;
        }
        return avgT/count;
    }
    
    void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double temp = averageTemperatureInFile(tester(fr));
        System.out.println("Average temperature in file is "+temp);
    }
    
    double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        float avg = 0;
        int count = 0;
        for(CSVRecord rec : parser){
            if(Float.parseFloat(rec.get("Humidity")) >= (float)value)
            {
                avg += Float.parseFloat(rec.get("TemperatureF"));
                count += 1;
            }
        }
        if(count > 0)
            return avg/count;
        else
            return 0;
    }
    
    
    void testAveragetemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        
        double avg = averageTemperatureWithHighHumidityInFile(tester(fr), 80);
        if(avg == 0)
            System.out.println("No temperatures with that humidity");
        else
            System.out.println("Avereg temp when high umidity is "+avg);
    }
    
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        FileResource fr = new FileResource();
        Parser1 parser = new Parser1();
        
        System.out.println(parser.CountryInfo(parser.tester(fr), "Germany"));
       
        String item1 = sc.next();
        String item2 = sc.next();
        parser.listExportersTwoProducts(parser.tester(fr), item1, item2);
        
        
        System.out.println(parser.numberOfExporters(parser.tester(fr), "gold"));
        parser.bigExporters(parser.tester(fr), "$999999999");
        
        
    }
}
