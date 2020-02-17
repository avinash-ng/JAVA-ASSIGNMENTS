
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Tester
{
    void testEncrypt(){
        
        int arr[] = new int[]{17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(arr);
        FileResource fr = new FileResource("/home/kolaparthi/Downloads/VigenereTestData/titus-small.txt");
        String text = fr.asString();
        CaesarCipher cc = new CaesarCipher(1);
        System.out.println(vc.encrypt(text));
    }
        
}
