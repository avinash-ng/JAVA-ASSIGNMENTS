/**
 * Create three interfaces, each with two methods.
 * Inherit a new interface that combines the three, adding a new method.
 * Create a class by implementing the new interface and also inheriting from a concrete class.
 * Now write four methods, each of which takes one of the four interfaces as an argument.
 * In main( ), create an object of your class and pass it to each of the methods
 */

import java.util.logging.Logger;
import java.util.logging.Level;

interface Book{
    String getBookAuthor();
    String getBookISBN();
}

interface Journal{
    String getJournalName();
    String getJournalType();
}

interface CD{
    String getAboutCD();
    String getCDSize();
}

interface Library extends Book, Journal, CD{
    String getLocation();
}

class Librarian{
    String name;
    Librarian(){

    }

    Librarian(String s){
        name = s;
    }
    String getName(){
        return name;
    }
}

class MobileLibrary extends Librarian implements Library {


    public String getLocation(){
        return " End of the street ";
    }

    public String getBookAuthor(){
        return "Andrew ng";
    }

    public String getJournalName(){
        return "Deep Learning";
    }/**
 * Create three interfaces, each with two gets.
 * Inherit a new interface that combines the three, adding a new get.
 * Create a class by implementing the new interface and also inheriting from a concrete class.
 * Now write four gets, each of which takes one of the four interfaces as an argument.
 * In main( ), create an object of your class and pass it to each of the gets
 */

import java.util.logging.Logger;
import java.util.logging.Level;

interface Book{
    String getBookAuthor();
    String getBookISBN();
}

interface Journal{
    String getJournalName();
    String getJournalType();
}

interface CD{
    String getAboutCD();
    String getCDSize();
}

interface Library extends Book, Journal, CD{
    String getLocation();
}

class Librarian{
    String name;
    Librarian(){

    }

    Librarian(String s){
        name = s;
    }
    String getName(){
        return name;
    }
}

class MobileLibrary extends Librarian implements Library {


    public String getLocation(){
        return " End of the street ";
    }

    public String getBookAuthor(){
        return "Andrew ng";
    }

    public String getJournalName(){
        return "Deep Learning";
    }

    public String getJournalType(){
        return "Weekly";
    }

    public String getBookISBN(){
        return "ISBN77252900170";
    }

    public String getCDSize(){
        return "200MB size disk";
    }

    public String getAboutCD(){
        return "CD about ML";
    }

}


public class InterfaceDriver {
    public String getAboutCD(CD cd){
        return cd.getAboutCD();
    }

    public String getBookISBN(Book book){
        return book.getBookISBN();
    }

    public String getJournalType(Journal journal){
        return journal.getJournalType();
    }
    public String getGetLocation(Library library){
        return library.getLocation();
    }

    public static void main(String args[]){
        Logger logger = Logger.getLogger(InterfaceDriver.class.getName());
        MobileLibrary mobileLibrary = new MobileLibrary();
        InterfaceDriver driverObj = new InterfaceDriver();


//         System.out.println(d.getAboutCD(ml));
        logger.log(Level.INFO, driverObj.getAboutCD(mobileLibrary));
//         System.out.println(d.getBookISBN(ml));
        logger.log(Level.INFO, driverObj.getBookISBN(mobileLibrary));
//         System.out.println(d.getJournalType(ml));
        logger.log(Level.INFO, driverObj.getJournalType(mobileLibrary));
//         System.out.println(d.getGetLocation(ml));
        logger.log(Level.INFO, driverObj.getGetLocation(mobileLibrary));
    }
}


    public String getJournalType(){
        return "Weekly";
    }

    public String getBookISBN(){
        return "ISBN77252900170";
    }

    public String getCDSize(){
        return "200MB size disk";
    }

    public String getAboutCD(){
        return "CD about ML";
    }

}


public class InterfaceDriver {
    public String methodAboutCD(CD cd){
        return cd.getAboutCD();
    }

    public String methodBookISBN(Book book){
        return book.getBookISBN();
    }

    public String methodJournalType(Journal journal){
        return journal.getJournalType();
    }
    public String methodGetLocation(Library library){
        return library.getLocation();
    }

    public static void main(String args[]){
        MobileLibrary mobileLibrary = new MobileLibrary();
        InterfaceDriver driverObj = new InterfaceDriver();


//         System.out.println(d.methodAboutCD(ml));
        logger.log(Level.INFO, driverObj.methodAboutCD(mobileLibrary));
//         System.out.println(d.methodBookISBN(ml));
        logger.log(Level.INFO, driverObj.methodAboutISBN(mobileLibrary));
//         System.out.println(d.methodJournalType(ml));
        logger.log(Level.INFO, driverObj.methodJournalType(mobileLibrary));
//         System.out.println(d.methodGetLocation(ml));
        logger.log(Level.INFO, driverObj.methodGetLocation(mobileLibrary));
    }
}
