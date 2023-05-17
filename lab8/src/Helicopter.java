public class Helicopter extends Vehicle {
    private double mpg = 0.3;
    public Helicopter() {
        nVehicles += 1;
    }

    public Helicopter(double mpg) {
        this.mpg = mpg;
        nVehicles += 1;
    }

    public void movingForward() {
        System.out.println("Helicopter Moving Forward");
    }

    public void movingBackward() {
        System.out.println("Helicopter Moving Backward");
    }

    public void movingUp() {
        System.out.println("Helicopter Moving Up");
    }

    public void movingDown() {
        System.out.println("Helicopter Moving Down");
    }

    public double getMPG() {
        return mpg;
    }

    public String toString() {
        String output = "Helicopter: ";
        output += mpg;
        return output;
    }


}
