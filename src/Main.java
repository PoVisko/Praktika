import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        int numLowestFloor = -2;
        int numHighestFloor = 8;
        ArrayList <Integer> numTotalFloors = new ArrayList<>();
        int numEntryFloor = -3;
        String vehicleType = "E";
        int output;

        /*
        Fill the list with available floors
         */
        for (int i=numLowestFloor; i<numHighestFloor+1; i++){
            if (i == 0) {
                continue;
            }
            else {
                numTotalFloors.add(i);
            }
        }

        /*
        Checks the closest parking space depending on vehicle type
         */
        if (vehicleType == "P") {
            output = numEntryFloor;;
        } else if (vehicleType == "E" && numEntryFloor == numTotalFloors.get(numTotalFloors.size() -1)) {
            output = numEntryFloor;
        } else if (vehicleType == "E" && numEntryFloor < numTotalFloors.get(numTotalFloors.size() -1)) {
            output = numTotalFloors.get(numTotalFloors.size() - 2);
        } else if (vehicleType == "V" && numEntryFloor == numTotalFloors.get(0)) {
            output = numEntryFloor;
        } else if (vehicleType == "V" && numEntryFloor > numTotalFloors.get(0)) {
            output = numTotalFloors.get(1);
        }

        // Data Testing
        // System.out.println(numTotalFloors.toString());
        System.out.println(output);
    }
}
