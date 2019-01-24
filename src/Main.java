import java.util.*;

public class Main {

    public static void main(String[] args) {
        int lowestFloor = 0;
        int highestFloor = 0;
        try {
            lowestFloor = Integer.parseInt(args[0]);
            highestFloor = Integer.parseInt(args[1]);
        } catch (NumberFormatException | NullPointerException nfe){
            System.out.println("Error. The floor number is not an integer.");
            System.exit(0);
        }


        Boolean continueProgram = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vehicle types: p - petrol, d - diesel, e - electric, v - van");

        // Examples of input: p1, e-3, v4, etc.
        while (continueProgram) {
            System.out.println("Enter vehicle type and entry floor number or q to quit program");
            String input = sc.nextLine();
            if (input.toLowerCase().equals("q")){
                continueProgram = false;
                continue;
            }
            else {
                String firstChar = input.substring(0,1).toLowerCase();
                String restString = input.substring(1);
                if (isInputValid(firstChar, restString)){
                    System.out.println("Processing data");
                    process(lowestFloor, highestFloor, firstChar, restString);
                } else {
                    System.out.println("Error. Enter valid input data");
                }
            }
        }
    }

    /*
    checks if user-entered vehicle type and floor number is correct
     */
    public static boolean isInputValid(String firstChar, String restString){
        return isVehicleTypeValid(firstChar) && isEntryFloorAnInteger(restString);
    }

    /*
    checks if vehicle type is valid
     */
    public static boolean isVehicleTypeValid(String vehicleType){
        return (vehicleType.equals("p") || vehicleType.equals("d") || vehicleType.equals("e") || vehicleType.equals("v"));
    }

    /*
    checks if user-entered floor number is an integer
     */
    public static boolean isEntryFloorAnInteger(String entryFloor) {
        try {
            Integer.parseInt(entryFloor);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    /*
    main process combining other methods into final output
     */
    public static void process(int lowestFloor, int highestFloor, String vehicleType, String entryFloorString) {
        int entryFloor = Integer.parseInt(entryFloorString);
        ArrayList<Integer> totalNumOfFloors;

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
    public static ArrayList<Integer> fillListWithFloorNumbers(int lowestFloor, int highestFloor) {
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
  Checks which vehicle type was entered in input
   */
    private static String determineVehicleType(String vehicleType) {
        if (vehicleType.equals("p") || vehicleType.equals("d")) {
            return "p";
        } else if (vehicleType.equals("e")) {
            return "e";
        } else {
            return "v";
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
        if (isEntryFloorValid(entryFloor, numOfTotalFloors)) {
            if ((determineVehicleType(vehicleType) == "p") ||
                    (determineVehicleType(vehicleType) == "e" && isFloorHighestInLot(entryFloor, numOfTotalFloors)) ||
                    (determineVehicleType(vehicleType) == "v" && isFloorLowestInLot(entryFloor, numOfTotalFloors))) {
                return Integer.toString(entryFloor);
            } else if (determineVehicleType(vehicleType) == "e" && !isFloorHighestInLot(entryFloor, numOfTotalFloors)) {
                return Integer.toString(numOfTotalFloors.get(numOfTotalFloors.size() - 2));
            } else {
                return Integer.toString(numOfTotalFloors.get(1));
            }
        } else {
            return "Error. You can't enter the parking lot to a floor that doesn't exist.";
        }
    }
}
