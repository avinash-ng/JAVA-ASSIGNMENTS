/**
1. Complete writing the method getNumPoints that has one parameter s that is of type Shape. This method returns an integer that is the number of points in Shape s. Hint: You will need to iterate over all the points in the Shape S and count them.

2. Add code in the method testPerimeter to call getNumPoints and to print the result.

3. Complete writing the method getAverageLength that has one parameter s that is of type Shape. This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.

4. Add code in the method testPerimeter to call the method getAverageLength and to print out the result. Note if you were to select the file example1.txt, then the average side length should be 4.0.

5. Complete writing the method getLargestSide that has one parameter s that is of type Shape. This method returns a number of type double that is the longest side in the Shape S.

6. Add code in the method testPerimeter to call the method getLargestSide and to print out the result. Note if you were to select the file example1.txt, then the longest side should be 5.0.

7. Complete writing the method getLargestX that has one parameter s that is of type Shape. This method returns a number of type double that is the largest x value over all the points in the Shape s.

8. Add code in the method testPerimeter to call the method getLargestX and to print out the result. Note if you were to select the file example1.txt, then the longest side should be 4.0. 
 */

/**
1. Complete writing the method getLargestPerimeterMultipleFiles that has no parameters. This method creates a DirectoryResource (so you can select multiple files) and then iterates over these files. For each File f, it converts the file into a FileResource with the line

    FileResource fr = new FileResource(f);

    Then it creates a Shape from the FileResource and calculates the shapes perimeter. What else does it need to do? It needs to return the the largest perimeter over all the shapes in the files you have selected.

2. Finish writing the void method testPerimeterMultipleFiles to call getLargestPerimeterMultipleFiles and to print out the largest such perimeter. This method has no parameters and no return value. You will select the files when you run this method (hint: see our documentation for the DirectoryResource class).

3. Finish writing the method getFileWithLargestPerimeter that has no parameters. This method should, like the getLargestPerimeterMultipleFiles method, create its own Directory Resource, except that this new method returns the File that has the largest such perimeter, so it has return type File.

4. Add code to the method testFileWithLargestPerimeter to call getFileWithLargestPerimeter. For the File that is returned, print the name of that file.
 */

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;  
        for(Point p : s.getPoints())
        {
            count += 1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgLen = getPerimeter(s)/getNumPoints(s);
        return avgLen;
    }

    public double getLargestSide(Shape s) {
        
        Point p = s.getLastPoint();
        double dist = 0.0;
        for(Point p1 : s.getPoints()){
            double curr_dist = p.distance(p1);
            p = p1;
            if(dist < curr_dist){
                    dist = curr_dist;
            }
        }
        return dist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double x_val = -1.0D;
        double curr_x;
        for(Point p : s.getPoints()){
            curr_x = p.getX();
            if(curr_x > x_val)
                x_val = curr_x;
        }
        return x_val;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largest = -1.0D;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(largest < perimeter){
                largest = perimeter;
            }
        }
        return largest;
    }

    public File getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largest = -1.0D;
        File temp = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(largest < perimeter){
                largest = perimeter;
                temp = f;
            }
        }
        return temp;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double largestSide = getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("Num of points = " + points);
        System.out.println("Largest Side is = " + largestSide);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        
        double largest_perimeter = getLargestPerimeterMultipleFiles();
        System.out.println(largest_perimeter);
    }

    public void testFileWithLargestPerimeter() {
        File f = getFileWithLargestPerimeter();
        System.out.println(f.getName());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        Shape s = new Shape();
        s.addPoint(new Point(3, 4));
        s.addPoint(new Point(-1, 1));
        System.out.println(pr.getNumPoints(s));
        System.out.println(pr.getAverageLength(s));
        System.out.println(pr.getPerimeter(s));

    }
}
