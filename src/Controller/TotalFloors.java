package Controller;

// Instance of it contains the lowest and the highest floor of the parking lot
public class TotalFloors {
    private int lowerFloor;
    private int upperFloor;

    public TotalFloors(int lowerFloor, int upperFloor) {
        this.lowerFloor = lowerFloor;
        this.upperFloor = upperFloor;
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
}