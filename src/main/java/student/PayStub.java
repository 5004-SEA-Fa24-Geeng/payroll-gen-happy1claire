package student;

/**
 * This is a class store all information that a pay stub need.
 */
public class PayStub implements IPayStub {
    /** String holds the employee id.*/
    private String employeeID;
    /** String holds the employee type.*/
    private String name;
    /** Double holds the employee pay rate.*/
    private double taxPaid;
    /** Double holds the employee year to date earning.*/
    private double ytdEarnings;
    /** Double holds the employee year to date paid tax.*/
    private double ytdTaxesPaid;
    /** Double holds the employee net pay of this payment period.*/
    private double netPay;


    /**
     * Default constructor for all pay stub.
     * @param employeeID employee id
     * @param name employee name
     * @param pay  net pay of this payment period
     * @param taxesPaid tax paid for this payment period
     * @param ytdEarnings year to date earning
     * @param ytdTaxesPaid year to date paid tax
     */
    public PayStub(String employeeId,
                   String name,
                   double pay,
                   double taxesPaid,
                   double ytdEarnings,
                   double ytdTaxesPaid
                   ) {
        this.employeeID = employeeId;
        this.name = name;
        this.netPay = pay;
        this.taxPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;

    }

    /**
     * return employee id.
     * @return employee id
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * return net pay for this payment period.
     * @return net pay for this payment period
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * return tax paid for this payment period.
     * @return tax paid for this payment period
     */
    @Override
    public double getTaxesPaid() {
        return taxPaid;
    }

    /**
     * Generate string for csv file.
     * @return string for csv file
     */
    @Override
    public String toCSV() {
        return this.name + "," + this.netPay + ","  + this.taxPaid + "," + this.ytdEarnings + "," + this.ytdTaxesPaid;
    }
}
