public class Train extends Vehicle {
    private double mpg = 30;
    public Train() {
        nVehicles += 1;
    }
    public Train(double mpg) {
        this.mpg = mpg;
        nVehicles += 1;
    }

    public void movingForward() {
        System.out.println("Train Moving Forward");
    }

    public void movingBackward() {
        System.out.println("Train Moving Backward");
    }

    public double getMPG() {
        return mpg;
    }

    public void enteringStation() {
        System.out.println("Train Entering Station");
    }

    public void leavingStation() {
        System.out.println("Train Leaving Station");
    }

    public String toString() {
        String output = "Train: ";
        output += mpg;
        return output;
    }
}
