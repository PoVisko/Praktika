package Controller;

// Instance of it contains the lowest and the highest floor of the parking lot
public class TotalFloors {
    private int lowerFloor;
    private int upperFloor;
    private int [] floorArray;

    public TotalFloors(int lowerFloor, int upperFloor) {
        this.lowerFloor = lowerFloor;
        this.upperFloor = upperFloor;
        int floorArrayMin = lowerFloor;
        int floorArrayMax = upperFloor;
        int floorArrayCount = floorArrayMax - floorArrayMin + 1;
        int[] floorArray = new int [floorArrayCount];
        for (int i = 0; i< floorArrayCount; i++, floorArrayMin++) {
            floorArray[i] = floorArrayMin;
        }
        this.floorArray = floorArray;
    }

    public int getLowerFloor () {
        return lowerFloor;
    }

    public void setLowerFloor (int lowerFloor) {
        this.lowerFloor = lowerFloor;
    }

    public int getUpperFloor () {
        return upperFloor;
    }

    public void setUpperFloor (int upperFloor) {
        this.upperFloor = upperFloor;
    }

    public int[] getFloorArray () {
        return floorArray;
    }

    public void setFloorArray (int[] floorArray) {
        this.floorArray = floorArray;
    }
}