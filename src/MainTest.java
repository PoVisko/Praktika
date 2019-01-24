import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static Main testedClass;

    @BeforeAll
    static void setUp() {
        testedClass = new Main();
    }

    @Test
    void checkIfLowerCaseEIsCorrectVehicleType(){
        assertTrue(testedClass.isVehicleTypeValid("e"));
    }

    @Test
    void checkIfNonIntegerIsValidInput () {
        assertFalse(testedClass.isInputValid("e", "e"));
    }

    @Test
    void checkIfNonIntegerIsValidEntryFloor () {
        assertFalse(testedClass.isEntryFloorAnInteger("S"));
    }

    @Test
    void checkIfZeroIsValidEntryFloor () {
        ArrayList<Integer> arrayList = new ArrayList<>();
        assertFalse(testedClass.isEntryFloorValid(0, arrayList));
    }

}