import java.awt.Color;
public class Triangle {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter() {
        // Calculates the perimeter of a triangle,
        // using the formula: width + 2 * sqrt(height ^ 2 + (0.5 * width) ^ 2)
        return this.width + 2 * Math.pow((Math.pow(this.height, 2) + Math.pow(this.width * 0.5, 2)), 0.5);
    }

    public double calculateArea() {
        // Calculates the area of a triangle, using the formula: area = width * height * 0.5
        return 0.5 * this.width * this.height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Color getColor() {
        return this.color;
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
}
