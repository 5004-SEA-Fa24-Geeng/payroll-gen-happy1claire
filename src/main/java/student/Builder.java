package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] employeeData = csv.split(",");
        if (employeeData.length != 7) {
            throw new IllegalArgumentException("Csv data must contains 7 elements");
        }

        try {
            double payRate = Double.parseDouble(employeeData[3]);
            double preTaxDeduction = Double.parseDouble(employeeData[4]);
            double ytdEarnings = Double.parseDouble(employeeData[5]);
            double ytdTaxesPaid = Double.parseDouble(employeeData[6]);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Double type required." + e.getMessage());
        }

        if (employeeData[0].equals("HOURLY")) {
            return new HourlyEmployee(
                    employeeData[0],
                    employeeData[1],
                    employeeData[2],
                    Double.parseDouble(employeeData[3]),
                    Double.parseDouble(employeeData[4]),
                    Double.parseDouble(employeeData[5]),
                    Double.parseDouble(employeeData[6]));
        } else {
            return new SalaryEmployee(
                    employeeData[0],
                    employeeData[1],
                    employeeData[2],
                    Double.parseDouble(employeeData[3]),
                    Double.parseDouble(employeeData[4]),
                    Double.parseDouble(employeeData[5]),
                    Double.parseDouble(employeeData[6]));
        }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] timeCardData = csv.split(",");
        return new TimeCard(timeCardData[0], Double.parseDouble(timeCardData[1]));
    }
}
