package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {

    private PayStub testPayStub;

    @BeforeEach
    void setUp() {
        testPayStub = new PayStub("n202",
                "Cook",
                500,
                200,
                500,
                200);
    }

    @Test
    void getEmployeeID() {
        assertEquals("n202", testPayStub.getEmployeeID());
    }

    @Test
    void getPay() {
        assertEquals(500, testPayStub.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(200, testPayStub.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Cook,500.0,200.0,500.0,200.0", testPayStub.toCSV());
    }
}