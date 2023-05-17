import java.awt.Color;


public class Circle {
    private double x;
    private double y;
    private double radius;
    private Color color;
    public Circle(double x, double y, double radius) {
        // Circle Constructor
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public double calculatePerimeter() {
        // Calculates the perimeter of a circle
        return 2 * Math.PI * this.radius;
    }

    public double calculateArea() {
        // Calculates the area of a circle
        return Math.PI * this.radius * this.radius;
    }

    public void setColor(Color color) {
        // Sets color
        this.color = color;
    }

    public void setPos(double x, double y) {
        // Sets x and y positions
        this.x = x;
        this.y = y;
    }

    public void setRadius(double radius) {
        // Sets radius
        this.radius = radius;
    }

    public Color getColor() {
        // Gets color
        return this.color;
    }

    public double getXPos() {
        // Gets x coordinate
        return this.x;
    }

    public double getYPos() {
        // Gets y coordinate
        return this.y;
    }

    public double getRadius() {
        // Gets radius
        return this.radius;
    }
}
