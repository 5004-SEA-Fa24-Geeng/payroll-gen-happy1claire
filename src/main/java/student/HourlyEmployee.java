package student;

/**
 * This is a class that represent all information for hourly employee.
 */
public class HourlyEmployee extends Employee {
    /**
     * Maximum working hours before over time.
     */
    private double inTimeHoursWorked = 40;
    /**
     * Standard of overtime working hours.
     */
    private double overTime = 40;
    /**
     * Overtime working hours pay rate.
     */
    private double overTimePayRate = 1.5;

    /**
     * Constructor for hourly employee.
     *
     * @param name             employee name
     * @param id               employee id
     * @param payRate          employee pay rate
     * @param pretaxDeductions employee pretax deduction
     * @param ytdEarnings      year to date earning
     * @param ytdTaxesPaid     year to date paid tax
     */
    public HourlyEmployee(String name,
                          String id,
                          double payRate,
                          double ytdEarnings,
                          double ytdTaxesPaid,
                          double pretaxDeductions
    ) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    /**
     * Generate pay stub based on employee's information and hours worked.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return Employee's pay stub
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        double overTimeHoursWorked = hoursWorked - this.overTime;

        if (hoursWorked <= 40 && hoursWorked > 0) {
            double netPay = (this.getPayRate() * hoursWorked - this.getPretaxDeductions()) * (1 - this.getTaxRate());
            netPay = Employee.roundedUpByBD(netPay);

            double taxPaid = (this.getPayRate() * hoursWorked - this.getPretaxDeductions()) * this.getTaxRate();
            taxPaid = Employee.roundedUpByBD(taxPaid);

            this.addYtdEarnings(netPay);
            this.addYtdTaxesPaid(taxPaid);

            IPayStub payStub = new PayStub(this.getID(),
                    this.getName(),
                    netPay,
                    taxPaid,
                    this.getYTDEarnings(),
                    this.getYTDTaxesPaid()
            );
            this.setPayStub(payStub);

            return payStub;

        } else if (hoursWorked > 40) {
            double inTimePay = this.getPayRate() * inTimeHoursWorked;

            double overTimePay = this.getPayRate() * overTimePayRate * overTimeHoursWorked;

            double netPay = (inTimePay + overTimePay - this.getPretaxDeductions()) * (1 - this.getTaxRate());
            netPay = Employee.roundedUpByBD(netPay);

            double taxPaid = (inTimePay + overTimePay - this.getPretaxDeductions()) * this.getTaxRate();
            taxPaid = Employee.roundedUpByBD(taxPaid);

            this.addYtdEarnings(netPay);
            this.addYtdTaxesPaid(taxPaid);

            IPayStub payStub = new PayStub(this.getID(),
                    this.getName(),
                    netPay,
                    taxPaid,
                    this.getYTDEarnings(),
                    this.getYTDTaxesPaid()
            );
            this.setPayStub(payStub);

            return payStub;
        } else {
            return null;
        }
    }
}
