
/**
 * Write a description of class ImageInversion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions
{
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel in = inImage.getPixel(pixel.getX(), pixel.getY());
            int red = in.getRed();
            int blue = in.getBlue();
            int green = in.getGreen();
            pixel.setRed(255-red);
            pixel.setBlue(255-blue);
            pixel.setGreen(255-green);
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
                ImageResource inImage = new ImageResource(f);
                String inName = inImage.getFileName();
                String outName = "inversion-"+inName;
                ImageResource out = makeInversion(inImage);
                out.setFileName(outName);
                out.save();
            }
    }
}
