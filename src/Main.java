import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        int numLowestFloor = -4;
        int numHighestFloor = 4;
        ArrayList <Integer> numTotalFloors = new ArrayList<Integer>();
        int numBoomBarrierFloor;
        char vehicleType;

        // Data Testing
        // System.out.println(Arrays.toString(totalFloors.getFloorArray()));


        for (int i=numLowestFloor; i<numHighestFloor+1; i++){
            if (i == 0) {
                continue;
            }
            else {
                numTotalFloors.add(i);
            }
        }
        System.out.println(numTotalFloors.toString());

    }
}
