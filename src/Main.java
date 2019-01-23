import java.util.*;

public class Main {

    public static void main(String[] args) {
        int lowestFloor = 7;
        int highestFloor = 8;
        ArrayList <Integer> totalNumOfFloors;
        int entryFloor = 8;
        String vehicleType = "V";
        String output;

        /*
        Checks the closest parking space depending on vehicle type
         */
        if (lowestFloor > highestFloor) {
            output = "The lowest floor of the parking lot can't be higher than the highest floor.";
        } else if (entryFloor >= totalNumOfFloors.get(0) &&
                entryFloor <= totalNumOfFloors.get(totalNumOfFloors.size() - 1) &&
                entryFloor != 0) {
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
            } else {
                output = Integer.toString(entryFloor);
            }
        } else {
            output = "You can't enter the lot because the floor you're entering to does not exist.";
        }

        /*
        Prints the output message
         */
        System.out.println(output);
    }

    /*
    Checks if entered vehicle type is correct
     */
    private static String checkVehicleType (String vehicleType) {
        if (vehicleType == "P" || vehicleType == "p" || vehicleType == "D" || vehicleType == "d") {
            return "P";
        } else if (vehicleType == "E" || vehicleType == "e") {
            return "E";
        } else if (vehicleType == "V" || vehicleType == "v") {
            return "V";
        } else {
            return "Error vehicleType";
        }
    }

    /*
    Checks if a entry point exists on a given parking lot floor
     */
    private static boolean isEntryFloorValid (int entryPoint, ArrayList <Integer> totalNumOfFloors) {
        if (totalNumOfFloors.contains(entryPoint)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Checks if lowest floor number is lower than the highest floor number
     */
    private static boolean isLowestFloorValid (int lowestFloor, int highestFloor) {
        if (lowestFloor <= highestFloor) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Fills the list with available parking lot floors
    */
    private static ArrayList <Integer> fillListWithFloorNumbers (int lowestFloor, int highestFloor) {
        ArrayList <Integer> totalNumOfFloors = new ArrayList<>();
        if (isLowestFloorValid(lowestFloor, highestFloor)) {
            for (int i=lowestFloor; i < highestFloor+1; i++){
                if (i == 0) {
                    continue;
                }
                else {
                    totalNumOfFloors.add(i);
                }
            }
            return totalNumOfFloors;
        } else {
            for (int i = highestFloor; i < lowestFloor + 1; i++) {
                if (i == 0) {
                    continue;
                } else {
                    totalNumOfFloors.add(i);
                }
            }
            return totalNumOfFloors;
        }

    }


}
