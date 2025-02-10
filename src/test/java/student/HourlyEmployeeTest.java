package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HourlyEmployeeTest {

    private IEmployee testEmployee;

    @BeforeEach
    void setUp() {
        testEmployee = new HourlyEmployee("Rock",
                "x100",
                100,
                0,
                0,
                100);
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", testEmployee.getEmployeeType());
    }

    @Test
    void runPayroll() {
        double hoursWorked = 20;
        IPayStub testPayStub = testEmployee.runPayroll(hoursWorked);

        assertEquals(1469.65, testPayStub.getPay());
        assertEquals(430.35, testPayStub.getTaxesPaid());
        assertEquals(1469.65, testEmployee.getYTDEarnings());
        assertEquals(430.35, testEmployee.getYTDTaxesPaid());
    }
}