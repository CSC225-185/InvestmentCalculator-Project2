package futureinvestment;

/**
 * CSC-225
 * Date: 10/5/2017
 * Author: Jacob Johncox
 * File: Investment.java
 * Description: This class is the representation of a single Investment in the InvestmentCalculator class
 */
public class Investment {
    private double monthlyInterestRate;
    private int numberOfYears;
    private double investmentAmount;
    private java.util.Date investmentDate;

    /**
     * The default constructor
     */
    public Investment() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a investment with specified monthly interest rate,
     * number of years, and investment amount.
     * @param monthlyInterestRate The interest rate of the investment.
     * @param investmentAmount The initial amount of the investment.
     * @param numberOfYears The number of years to pay off the investment.
     */
    public Investment(double monthlyInterestRate, int numberOfYears,
                double investmentAmount) {
        this.monthlyInterestRate = monthlyInterestRate;
        this.numberOfYears = numberOfYears;
        this.investmentAmount = investmentAmount;
        investmentDate = new java.util.Date();
    }

    /**
     * Return monthlyInterestRate
     * @return The interest rate of the investment.
     */
    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    /**
     * Set a new monthlyInterestRate
     * @param monthlyInterestRate The interest rate of the investment.
     */
    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    /**
     * Return numberOfYears
     * @return The number of years to pay off the investment.
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     * @param numberOfYears The number of years to pay off the investment.
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return investmentAmount
     * @return The initial amount of the investment.
     */
    public double getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * Set a new investmentAmount
     * @param investmentAmount The initial amount of the investment.
     */
    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

//    /**
//     * Find monthly payment
//     * @return The monthly payment required
//     */
//    public double getMonthlyPayment() {
//        double monthlyInterestRate = monthlyInterestRate / 1200;
//        double monthlyPayment = investmentAmount * monthlyInterestRate / (1 -
//                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
//        return monthlyPayment;
//    }

    /**
     * Find total payment
     * @return The total amount to pay of the investment in it's entirety.
     */
    public double getFutureValue() {
//        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        double futureValue = this.getInvestmentAmount() * Math.pow(1 + (this.getMonthlyInterestRate() / 100),(this.getNumberOfYears() * 12));
        return futureValue;
    }

    /**
     * Return investment date
     * @return The date of the investment.
     */
    public java.util.Date getInvestmentDate() {
        return investmentDate;
    }
}