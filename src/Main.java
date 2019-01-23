import Controller.TotalFloors;


public class Main {

    public static void main(String[] args) {
        TotalFloors totalFloors = new TotalFloors(-2, 8);

        // Create an array containing all the parking lot floor numbers
        int floorArrayMin = totalFloors.getLowerFloor();
        int floorArrayMax = totalFloors.getUpperFloor();
        int floorArrayCount = floorArrayMax - floorArrayMin + 1;
        int[] floorArray = new int [floorArrayCount];
        for (int i = 0; i< floorArrayCount; i++, floorArrayMin++) {
            floorArray[i] = floorArrayMin;
        }
    }
}
