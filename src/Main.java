import java.util.*;

public class Main {

    public static void main(String[] args) {
        int lowestFloor = -2;
        int highestFloor = 8;
        ArrayList <Integer> totalNumOfFloors = new ArrayList<>();
        int entryFloor = -3;
        String vehicleType = "Z";
        String output;

        /*
        Fill the list with available floors
         */
        for (int i=lowestFloor; i<highestFloor+1; i++){
            if (i == 0) {
                continue;
            }
            else {
                totalNumOfFloors.add(i);
            }
        }

        /*
        Checks the closest parking space depending on vehicle type
         */
        if (entryFloor >= totalNumOfFloors.get(0) &&
                entryFloor <= totalNumOfFloors.get(totalNumOfFloors.size() - 1)) {
            if (lowestFloor < highestFloor) {
                if (vehicleType == "P") {
                    output = Integer.toString(entryFloor);
                } else if (vehicleType == "E" && entryFloor == totalNumOfFloors.get(totalNumOfFloors.size() - 1)) {
                    output = Integer.toString(entryFloor);
                } else if (vehicleType == "E") {
                    output = Integer.toString(totalNumOfFloors.get(totalNumOfFloors.size() - 2));
                } else if (vehicleType == "V" && entryFloor == totalNumOfFloors.get(0)) {
                    output = Integer.toString(entryFloor);
                } else if (vehicleType == "V") {
                    output = Integer.toString(totalNumOfFloors.get(1));
                } else {
                    output = "The type of vehicle you're using isn't suitable for our parking lot. Sorry.";
                }
            } else if (lowestFloor == highestFloor) {
                output = Integer.toString(entryFloor);
            } else {
                output = "The lowest floor of your building can't be higher than the highest floor.";
            }
        } else {
            output = "You can't enter the lot because the floor you're entering to does not exist.";
        }

        System.out.println(output);
    }
}
