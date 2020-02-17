/**
 * Create three interfaces, each with two methods.
 * Inherit a new interface that combines the three, adding a new method.
 * Create a class by implementing the new interface and also inheriting from a concrete class.
 * Now write four methods, each of which takes one of the four interfaces as an argument.
 * In main( ), create an object of your class and pass it to each of the methods
 */



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
    public String methodAboutCD(CD c){
        return c.getAboutCD();
    }

    public String methodBookISBN(Book b){
        return b.getBookISBN();
    }

    public String methodJournalType(Journal j){
        return j.getJournalType();
    }
    public String methodGetLocation(Library l){
        return l.getLocation();
    }

    public static void main(String args[]){
        MobileLibrary ml = new MobileLibrary();
        InterfaceDriver d = new InterfaceDriver();


        System.out.println(d.methodAboutCD(ml));
        System.out.println(d.methodBookISBN(ml));
        System.out.println(d.methodJournalType(ml));
        System.out.println(d.methodGetLocation(ml));
    }
}
