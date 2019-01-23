import java.util.*;

public class Main {

    public static void main(String[] args) {
        int lowestFloor = -2;
        int highestFloor = 5;
        ArrayList<Integer> totalNumOfFloors;
        int entryFloor = -2;
        String vehicleType = "";                                                   // "P" or "D" for petrol/diesel, "E" for electric, "V' for van

        totalNumOfFloors = fillListWithFloorNumbers (lowestFloor, highestFloor);    // if lowest floor number > highest, switches places
        System.out.println(printOutput (totalNumOfFloors, entryFloor, vehicleType));
    }

    /*
    Checks if a entry point is valid
     */
    private static boolean isEntryFloorValid(int entryPoint, ArrayList<Integer> totalNumOfFloors) {
        if (totalNumOfFloors.contains(entryPoint) && entryPoint != 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Checks if lowest floor number is lower than the highest floor number
     */
    private static boolean isLowestFloorValid(int lowestFloor, int highestFloor) {
        if (lowestFloor <= highestFloor) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Fills the list with available parking lot floors
    */
    private static ArrayList<Integer> fillListWithFloorNumbers(int lowestFloor, int highestFloor) {
        ArrayList<Integer> totalNumOfFloors = new ArrayList<>();
        if (isLowestFloorValid(lowestFloor, highestFloor)) {
            for (int i = lowestFloor; i < highestFloor + 1; i++) {
                if (i == 0) {
                    continue;
                } else {
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

    /*
  Checks if entered vehicle type is correct
   */
    private static String checkVehicleType(String vehicleType) {
        if (vehicleType == "P" || vehicleType == "p" || vehicleType == "D" || vehicleType == "d") {
            return "P";
        } else if (vehicleType == "E" || vehicleType == "e") {
            return "E";
        } else if (vehicleType == "V" || vehicleType == "v") {
            return "V";
        } else {
            return "Error";
        }
    }

    /*
    checks if the given floor is the highest in the parking lot
     */
    private static boolean isFloorHighestInLot(int floor, ArrayList<Integer> totalNumOfFloors) {
        if (floor == totalNumOfFloors.get(totalNumOfFloors.size() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    checks if the given floor is the lowest in the parking lot
     */
    private static boolean isFloorLowestInLot(int floor, ArrayList<Integer> totalNumOfFloors) {
        if (floor == totalNumOfFloors.get(0)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    prints output by using all the inputs and validation
     */
    private static String printOutput(ArrayList<Integer> numOfTotalFloors, int entryFloor, String vehicleType) {
        if (isEntryFloorValid(entryFloor, numOfTotalFloors) && checkVehicleType(vehicleType) != "Error") {
            if ((checkVehicleType(vehicleType) == "P") ||
                    (checkVehicleType(vehicleType) == "E" && isFloorHighestInLot(entryFloor, numOfTotalFloors)) ||
                    (checkVehicleType(vehicleType) == "V" && isFloorLowestInLot(entryFloor, numOfTotalFloors))) {
                return Integer.toString(entryFloor);
            } else if (checkVehicleType(vehicleType) == "E" && !isFloorHighestInLot(entryFloor, numOfTotalFloors)) {
                return Integer.toString(numOfTotalFloors.get(numOfTotalFloors.size() - 2));
            } else {
                return Integer.toString(numOfTotalFloors.get(1));
            }
        } else if (!isEntryFloorValid(entryFloor, numOfTotalFloors)) {
            return "Error. You can't enter the parking lot to a floor that doesn't exist.";
        } else {
            return "Error. The vehicle type you're entering with is not recognized by the boom barrier.";
        }
    }
}
