package student;

/**
 * This is a class that represent all information for salary employee.
 */
public class SalaryEmployee extends Employee {
    /**
     * Pay period for employee across entire year with biweekly payment.
     */
    private double payPeriod = 24;

    /**
     * Constructor for salary employee.
     *
     * @param name             employee name
     * @param id               employee id
     * @param payRate          employee pay rate
     * @param pretaxDeductions employee pretax deduction
     * @param ytdEarnings      year to date earning
     * @param ytdTaxesPaid     year to date paid tax
     */
    public SalaryEmployee(String name,
                          String id,
                          double payRate,
                          double ytdEarnings,
                          double ytdTaxesPaid,
                          double pretaxDeductions
    ) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Get employee type.
     * @return employee type
     */
    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    /**
     * Generate pay stub based on employee's information and hours worked.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return Employee's pay stub
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked >= 0) {
            double taxPaid = (this.getPayRate() / this.payPeriod - this.getPretaxDeductions()) * this.getTaxRate();
            taxPaid = Employee.roundedUpByBD(taxPaid);

            double netPay = (this.getPayRate() / this.payPeriod - this.getPretaxDeductions()) * (1 - this.getTaxRate());
            netPay = Employee.roundedUpByBD(netPay);

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
