package student;

import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This is a class that represent all information for hourly employee
 */
public class HourlyEmployee extends Employee {
    /** Maximum working hours before over time*/
    private double inTimeHoursWorked = 40;
    /** Standard of overtime working hours*/
    private double overTime = 40;
    /** Overtime working hours pay rate*/
    private double overTimePayRate = 1.5;

    /**
     * Constructor for hourly employee
     * @param employeeType employee type
     * @param name employee name
     * @param id employee id
     * @param payRate employee pay rate
     * @param pretaxDeductions employee pretax deduction
     * @param ytdEarnings year to date earning
     * @param ytdTaxesPaid year to date paid tax
     */
    public HourlyEmployee(String employeeType,
                          String name,
                          String id,
                          double payRate,
                          double ytdEarnings,
                          double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(employeeType, name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Generate pay stub based on employee's information and hours worked.
     * @param hoursWorked the hours worked for the pay period
     *
     * @return Employee's pay stub
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        double overTimeHoursWorked = hoursWorked - this.overTime;

        if (hoursWorked <= 40 && hoursWorked > 0) {
            double netPay = (this.payRate * hoursWorked - this.pretaxDeductions) * (1 - this.tax_rate);
            netPay = Employee.roundedUpByBD(netPay);

            double taxPaid = (this.payRate * hoursWorked - this.pretaxDeductions) * this.tax_rate;
            taxPaid = Employee.roundedUpByBD(taxPaid);

            this.ytdEarnings += netPay;
            this.ytdTaxesPaid += taxPaid;

            IPayStub payStub = new PayStub(this.id,
                    this.name,
                    netPay,
                    taxPaid,
                    this.ytdEarnings,
                    this.ytdTaxesPaid
                    );
            this.payStub = payStub;

            return payStub;

        } else if (hoursWorked > 40) {
            double inTimePay = this.payRate * inTimeHoursWorked;

            double overTimePay = this.payRate * overTimePayRate * overTimeHoursWorked;

            double netPay = (inTimePay + overTimePay - this.pretaxDeductions) * (1 - this.tax_rate);
            netPay = Employee.roundedUpByBD(netPay);

            double taxPaid = (inTimePay + overTimePay - this.pretaxDeductions) * this.tax_rate;
            taxPaid = Employee.roundedUpByBD(taxPaid);

            this.ytdEarnings += netPay;
            this.ytdTaxesPaid += taxPaid;

            IPayStub payStub = new PayStub(this.id,
                    this.name,
                    netPay,
                    taxPaid,
                    this.ytdEarnings,
                    this.ytdTaxesPaid
                    );
            this.payStub = payStub;

            return payStub;
        } else {
            return null;
        }
    }
}
