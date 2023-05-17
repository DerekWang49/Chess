public class Car extends Vehicle {
    private double mpg = 30;
    public Car() {
        nVehicles += 1;
    }
    public Car(double mpg) {
        this.mpg = mpg;
        nVehicles += 1;
    }

    public void movingForward() {
        System.out.println("Car Moving Forward");
    }

    public void movingBackward() {
        System.out.println("Car Moving Backward");
    }

    public double getMPG() {
        return mpg;
    }

    public String toString() {
        String output = "Car: ";
        output += mpg;
        return output;
    }

}
