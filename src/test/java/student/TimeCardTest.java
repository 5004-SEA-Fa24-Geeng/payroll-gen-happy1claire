package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {

    private TimeCard testTimeCard;

    @BeforeEach
    void setUp() {
        testTimeCard = new TimeCard("x909", 30);
    }

    @Test
    void getEmployeeID() {
        assertEquals("x909", testTimeCard.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(30, testTimeCard.getHoursWorked());
    }
}