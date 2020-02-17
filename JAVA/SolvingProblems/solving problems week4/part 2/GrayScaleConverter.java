
/**
 * Write a description of class GrayScaleConverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GrayScaleConverter
{
    
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
            
            Pixel in = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (in.getRed() + in.getBlue() + in.getGreen() )/3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }
    
    public void saveAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String inName = inImage.getFileName();
            String outName = "gray-" + inName;
            ImageResource outImage = makeGray(inImage);
            outImage.setFileName(outName);
            outImage.save();
        }
    }
}