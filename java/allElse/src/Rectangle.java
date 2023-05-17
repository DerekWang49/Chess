public class Rectangle {
    private int length;
    private int width;
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * length + 2 * width;
    }

    public int addArea(Rectangle other) {
        return area() + other.area();
    }

    public int addPerimeter(Rectangle other) {
        return perimeter() + other.perimeter();
    }

    public boolean equals(Rectangle other) {
        return length == other.length && width == other.width;
    }

    public String toString() {
        return "Length: " + length + ", Width: " + width + ", Area: " + area() +
                ", Perimeter: " + perimeter();
    }

    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle(5, 7);
        System.out.println(myRectangle);
    }
}
