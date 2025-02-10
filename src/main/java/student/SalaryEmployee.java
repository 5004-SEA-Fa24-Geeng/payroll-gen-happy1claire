package student;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This is a class that represent all information for salary employee
 */
public class SalaryEmployee extends Employee {
    /**
     * Pay period for employee across entire year with biweekly payment.
     */
    private double pay_period = 24;

    /**
     * Constructor for salary employee
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
                          double pretaxDeductions,
                          double ytdEarnings,
                          double ytdTaxesPaid
    ) {
        super(name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }

    @Override
    public String getEmployeeType() {
        return "Salary";
    }


    /**
     * Generate pay stub based on employee's information and hours worked.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return Employee's pay stub
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked > 0) {
            double taxPaid = (this.payRate / this.pay_period - this.pretaxDeductions) * this.tax_rate;
            taxPaid = Employee.roundedUpByBD(taxPaid);

            double netPay = (this.payRate / this.pay_period - this.pretaxDeductions) * (1 - this.tax_rate);
            netPay = Employee.roundedUpByBD(netPay);

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
