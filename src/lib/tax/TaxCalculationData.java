package lib.tax;

public class TaxCalculationData {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int numberOfMonthWorking;
    private int deductible;
    private MaritalStatus maritalStatus;
    private int numberOfChildren;

    public TaxCalculationData(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, MaritalStatus maritalStatus, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthWorking = numberOfMonthWorking;
        this.deductible = deductible;
        this.maritalStatus = maritalStatus;
        this.numberOfChildren = numberOfChildren;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getNumberOfMonthWorking() {
        return numberOfMonthWorking;
    }

    public int getDeductible() {
        return deductible;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}