package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This is an abstract class to store all information related to all kind of employees.
 */
public abstract class Employee implements IEmployee {

    /**
     * String holds the employee name.
     */
    private String name;
    /**
     * String holds the employee id.
     */
    private String id;
    /**
     * Double holds the employee pay rate.
     */
    private double payRate;
    /**
     * Double holds the employee year to date earning.
     */
    private double ytdEarnings;
    /**
     * Double holds the employee year to date paid tax.
     */
    private double ytdTaxesPaid;
    /**
     * Double holds the employee pretax deduction.
     */
    private double pretaxDeductions;
    /**
     * PayStub holds the employee pay stub of current period.
     */
    private IPayStub payStub;
    /**
     * Double holds the employee's pay rate.
     */
    private double taxRate = 0.2265;

    /**
     * Default constructor for all kind of employees.
     *
     * @param name             employee name
     * @param id               employee id
     * @param payRate          employee pay rate
     * @param pretaxDeductions employee pretax deduction
     * @param ytdEarnings      year to date earning
     * @param ytdTaxesPaid     year to date paid tax
     */
    public Employee(String name,
                    String id,
                    double payRate,
                    double ytdEarnings,
                    double ytdTaxesPaid,
                    double pretaxDeductions
    ) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * return employee name.
     * @return employee name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * return employee id.
     * @return employee id
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * return employee pay rate.
     * @return employee pay rate
     */
    @Override
    public double getPayRate() {
        return payRate;
    }


    /**
     * return employee year to date earning.
     * @return employee year to date earning
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    /**
     * return employee year to date tax paid.
     * @return employee year to date tax paid
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * return employee pretax deduction.
     * @return employee pretax deduction
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * return tax rate.
     * @return tax rate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * set pay stub for this payment period.
     * @param payStub the pay stub of this payment period
     */
    public void setPayStub(IPayStub payStub) {
       this.payStub = payStub;
    }

    /**
     * add the net  pay of this payment period to year to date earning.
     * @param earning the net pay of this payment period
     */
    public void addYtdEarnings(double earning) {
        this.ytdEarnings += earning;
    }

    /**
     add the tax par for this payment period to year to date earning.
     * @param tax the tax pay for this payment period
     */
    public void addYtdTaxesPaid(double tax) {
        this.ytdTaxesPaid += tax;
    }

    /**
     * return employee name for csv.
     * @return employee name for csv
     */
    @Override
    public String toCSV() {
        return this.getEmployeeType() + ","
                + this.name + ","
                + this.id + ","
                + this.payRate + ","
                + this.pretaxDeductions + ","
                + this.ytdEarnings + ","
                + this.ytdTaxesPaid;
    }

    /**
     * return double value with 0.01 round up precision.
     * @param d double value that need to be round up
     * @return double value
     */
    public static double roundedUpByBD(double d) {
        return BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
