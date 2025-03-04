import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.mpp2025.model.ComputerRepairRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        ComputerRepairRequest request = new ComputerRepairRequest(1, "Ion", "Addresa", "0777777777", "Mac", "13/1/2025", "nu porneste");
        assertEquals(1, request.getID());
        assertEquals("Ion", request.getOwnerName());
        assertEquals("Addresa", request.getOwnerAddress());
        assertEquals("0777777777", request.getPhoneNumber());
        assertEquals("Mac", request.getModel());
        assertEquals("13/1/2025", request.getDate());
        assertEquals("nu porneste", request.getProblemDescription());
    }
    @Test
    @DisplayName("Test 2") //test for returning empty stuff
    void test2() {
        ComputerRepairRequest request = new ComputerRepairRequest();
        assertEquals(0, request.getID());
        assertEquals("", request.getOwnerName());
        assertEquals("", request.getOwnerAddress());
        assertEquals("", request.getPhoneNumber());
        assertEquals("", request.getModel());
        assertEquals("", request.getDate());
        assertEquals("", request.getProblemDescription());
    }

}
