
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("short-test_log");
        obj.printAll();
    }
    
    public void testUniqueIp(){
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("short-test_log");
        obj.countUniqueIps();
    }
    
    public void testIpHigherThanNum(){
        int num = 200;
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("short-test_log");
        obj.printAllHigherThanNum(num);
    }
    
    public void testUniqueIPVisits(){
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("weblog-short_log");
        List<String> l = obj.uniqueIPVisitsOnDay("Sep 30");
        
    }
    
    public void testUniqueIpInRange(){
        int low = 300;
        int high = 399;
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("short-test_log");
   }
    
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("weblog3-short_log");
        HashMap<String , ArrayList<String> > al = obj.iPsForDays();
        for(String ans : obj.iPsWithMostVisitsOnDay(obj.iPsForDays(), "Sep 30"))
            System.out.println(ans);
        
    }
    
}
