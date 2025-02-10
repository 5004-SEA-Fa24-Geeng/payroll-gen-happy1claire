package student;

/**
 * This is a class store all information that a pay stub need.
 */
public class PayStub implements IPayStub {
    /** String holds the employee id*/
    private String EmployeeID;
    /** String holds the employee type*/
    private String name;
    /** Double holds the employee pay rate*/
    private double taxPaid;
    /** Double holds the employee year to date earning*/
    private double ytdEarnings;
    /** Double holds the employee year to date paid tax*/
    private double ytdTaxesPaid;
    /** Double holds the employee net pay of this payment period*/
    private double netPay;


    /**
     * Default constructor for all pay stub.
     * @param name employee name
     * @param pay  net pay of this payment period
     * @param TaxesPaid tax paid for this payment period
     * @param ytdEarnings year to date earning
     * @param ytdTaxesPaid year to date paid tax
     */
    public PayStub(String EmployeeID,
                   String name,
                   double pay,
                   double TaxesPaid,
                   double ytdEarnings,
                   double ytdTaxesPaid
                   ) {
        this.EmployeeID = EmployeeID;
        this.name = name;
        this.netPay = pay;
        this.taxPaid = TaxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;

    }

    /**
     * return employee id
     * @return employee id
     */
    public String getEmployeeID() {
        return EmployeeID;
    }

    /**
     * return net pay for this payment period
     * @return net pay for this payment period
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * return tax paid for this payment period
     * @return tax paid for this payment period
     */
    @Override
    public double getTaxesPaid() {
        return taxPaid;
    }

    /**
     * Generate string for csv file
     * @return string for csv file
     */
    @Override
    public String toCSV() {
        return this.name + "," + this.netPay + ","  + this.taxPaid + "," + this.ytdEarnings + "," + this.ytdTaxesPaid;
    }
}
