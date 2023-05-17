// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {
    }  // constructor




    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal


    public double drawFractal(String type) {
        // Set Canvas dimensions
        Canvas fractal = new Canvas(800, 800);
        // Draw shape based on user input
        if (type.equals("triangle")) {
            drawTriangleFractal(200, 200, 300, 500, Color.blue, fractal, 7, 0);
        } else if (type.equals("rectangle")) {
            drawRectangleFractal(200, 200, 300, 300, Color.blue, fractal, 7, 0);
        }
        else {
            drawCircleFractal(100, 400, 400, Color.blue, fractal, 7, 0);

        }
        return totalArea;
    }


    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level, int count) {
        if (count < level) {
            // Initializes and draws triangle
            Triangle myTriangle = new Triangle(x, y, width, height);
            myTriangle.setColor(c);
            can.drawShape(myTriangle);
            // Calculate the area of each triangle
            totalArea += myTriangle.calculateArea();
            // Randomly creates color
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            c = new Color(red, green, blue);
            // Draws multiple triangles until level reaches 0.
            // Each triangle is drawn at one of the base triangle's points
            drawTriangleFractal(width / 2, height / 2, x - width / 2, y, c, can, level,count + 1);
            drawTriangleFractal(width / 2, height / 2, x + width, y, c, can, level, count + 1);
            drawTriangleFractal(width / 2, height / 2, x + width / 4, y - height, c, can, level, count + 1);
        }

    }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level, int count) {
        // Keep count of the number of recursions
        if (count < level) {
            // Create a new circle with the given parameters
            Circle myCircle = new Circle(x, y, radius);
            myCircle.setColor(c);
            can.drawShape(myCircle);
            // Calculate the area of each circle
            totalArea += myCircle.calculateArea();
            // Generate random colors
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            c = new Color(red, green, blue);
            drawCircleFractal(radius / 2, x + 3 * radius / 2, y, c, can, level, count + 1);
            drawCircleFractal(radius / 2, x - 3 * radius / 2, y, c, can, level, count + 1);
            drawCircleFractal(radius / 2, x, y + 3 * radius / 2, c, can, level, count + 1);
            drawCircleFractal(radius / 2, x, y - 3 * radius / 2, c, can, level, count + 1);
        }
    }


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level, int count) {
        if (count < level) {
            Rectangle myRectangle = new Rectangle(x, y, height, width);
            myRectangle.setColor(c);
            can.drawShape(myRectangle);
            // Calculate the area of each rectangle
            totalArea += myRectangle.calculateArea();
            // Generate random colors
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            c = new Color(red, green, blue);
            drawRectangleFractal(width / 2, height / 2, x - width / 2, y - height / 2, c, can, level, count + 1);
            drawRectangleFractal(width / 2, height / 2, x + width, y - height / 2, c, can, level, count + 1);
            drawRectangleFractal(width / 2, height / 2, x - width / 2, y + height, c, can, level, count + 1);
            drawRectangleFractal(width / 2, height / 2, x + width, y + height, c, can, level, count + 1);
        }
    }

    // Asks for shape input and then draws the corresponding fractal.
    // Prints area of fractal
    public static void main(String[] args){
        System.out.println("Enter a shape: (circle, triangle, rectangle)");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        FractalDrawer fractal = new FractalDrawer();
        System.out.println(fractal.drawFractal(input));





        }
    }

