package student;

/**
 * This is a class store information that time cards needed.
 */
public class TimeCard implements ITimeCard {
    /** String holds the employee id.*/
    private final String employeeID;
    /** Double holds employee working hours for this payment period.*/
    private final double hoursWorked;

    /**
     * Default constructor for time card.
     * @param employeeID ID of employee
     * @param hoursWorked hours work on the pay period
     */
    public TimeCard(String employeeID, double hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * return employee id.
     * @return employee id
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * return working hours.
     * @return working hours
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
}
