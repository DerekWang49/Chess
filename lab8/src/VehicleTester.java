public class VehicleTester {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.movingForward();
        bike.movingBackward();
        Scooter scooter = new Scooter();
        scooter.movingBackward();
        scooter.movingForward();
    }
}
