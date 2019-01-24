import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static Main testedClass;

    @BeforeAll
    static void setUp() {
        testedClass = new Main();
    }

    @Test
    void checkIfUpperCaseAIsWrongCarLetter(){
        assertFalse(testedClass.isVehicleTypeValid("A"));
    }

}