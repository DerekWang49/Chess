import java.awt.Color;
public class Rectangle {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double calculatePerimeter() {
        // Calculates the perimeter of the rectangle by using the formula:
        // Height * 2 + Width * 2
        return 2 * this.height + 2 * this.width;
    }

    public double calculateArea() {
        // Calculates the area of the rectangle by using the formula:
        // Height * Width
        return this.height * this.width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setHeight(double height) {
        // Sets height of the rectangle
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getXPos() {
        return this.x;
    }

    public double getYPos() {
        return this.y;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public Color getColor() {
        return this.color;
    }



 }
