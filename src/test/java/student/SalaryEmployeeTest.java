package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    private IEmployee testEmployee;

    @BeforeEach
    void setUp() {
        testEmployee = new SalaryEmployee("Bob",
                "b220",
                200000,
                0,
                0,
                1000);
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", testEmployee.getEmployeeType());
    }

    @Test
    void runPayroll() {
        double hoursWorked = 20;
        IPayStub testPayStub = testEmployee.runPayroll(hoursWorked);

        assertEquals(5672.33, testPayStub.getPay());
        assertEquals(1661.0, testPayStub.getTaxesPaid());
        assertEquals(5672.33, testEmployee.getYTDEarnings());
        assertEquals(1661.0, testEmployee.getYTDTaxesPaid());

    }
}