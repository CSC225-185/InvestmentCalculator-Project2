package futureinvestment;

/**
 * CSC-225
 * Date: 10/5/2017
 * Author: Jacob Johncox
 * File: Investment.java
 * Description: This class is the representation of a single Investment in the InvestmentCalculator class
 */
public class Investment {
    private double annualInterestRate;
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
     * Construct a investment with specified annual interest rate,
     * number of years, and investment amount.
     * 
     * @param annualInterestRate The interest rate of the investment.
     * @param investmentAmount The initial amount of the investment.
     * @param numberOfYears The number of years to pay off the investment.
     */
    public Investment(double annualInterestRate, int numberOfYears,
                double investmentAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.investmentAmount = investmentAmount;
        investmentDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate
     * 
     * @return The interest rate of the investment.
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     * 
     * @param annualInterestRate The interest rate of the investment.
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     * 
     * @return The duration off the investment.
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     * 
     * @param numberOfYears The duration off the investment.
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return investmentAmount
     * 
     * @return The initial amount of the investment.
     */
    public double getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * Set a new investmentAmount
     * 
     * @param investmentAmount The initial amount of the investment.
     */
    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    /**
     * Find total payment
     * 
     * @return The total value of the investment in it's entirety.
     */
    public double getFutureValue() {
        double futureValue = this.getInvestmentAmount() * Math.pow(1 + ((this.getAnnualInterestRate() / 12) / 100),(this.getNumberOfYears() * 12));
        return futureValue;
    }

    /**
     * Return investment date
     * 
     * @return The date of the investment.
     */
    public java.util.Date getInvestmentDate() {
        return investmentDate;
    }
}