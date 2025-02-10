package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This is an abstract class to store all information related to all kind of employees
 */
public abstract class Employee implements IEmployee {

    /**
     * String holds the employee name
     */
    protected String name;
    /**
     * String holds the employee id
     */
    protected String id;
    /**
     * Double holds the employee pay rate
     */
    protected double payRate;
    /**
     * Double holds the employee year to date earning
     */
    protected double ytdEarnings;
    /**
     * Double holds the employee year to date paid tax
     */
    protected double ytdTaxesPaid;
    /**
     * Double holds the employee pretax deduction
     */
    protected double pretaxDeductions;
    /**
     * PayStub holds the employee pay stub of current period
     */
    protected IPayStub payStub;
    /**
     * Double holds the employee's pay rate
     */
    protected double tax_rate = 0.2265;

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
                    double pretaxDeductions,
                    double ytdEarnings,
                    double ytdTaxesPaid
    ) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * return employee name
     *
     * @return employee name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * return employee id
     *
     * @return employee id
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * return employee pay rate
     *
     * @return employee pay rate
     */
    @Override
    public double getPayRate() {
        return payRate;
    }


    /**
     * return employee year to date earning
     *
     * @return employee year to date earning
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    /**
     * return employee year to date tax paid
     *
     * @return employee year to date tax paid
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * return employee pretax deduction
     *
     * @return employee pretax deduction
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * return employee name for csv
     *
     * @return employee name for csv
     */
    @Override
    public String toCSV() {
        return this.name + "," +
                this.id + "," +
                this.payRate + "," +
                this.pretaxDeductions + "," +
                this.ytdEarnings + "," +
                this.ytdTaxesPaid;
    }

    /**
     * return double value with 0.01 round up precision
     *
     * @return double value
     */
    public static double roundedUpByBD(double d) {
        return BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
