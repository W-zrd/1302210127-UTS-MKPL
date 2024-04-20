package lib.tax;

public class TaxFunction {

    public static int calculateTax(TaxCalculationData taxCalculationData) {
        int tax = 0;

        if (taxCalculationData.getNumberOfMonthWorking() > 12) {
            System.err.println("More than 12 month working per year");
        }

        int numberOfChildren = Math.min(taxCalculationData.getNumberOfChildren(), 3);

        if (taxCalculationData.getMaritalStatus() == MaritalStatus.MARRIED) {
            tax = (int) Math.round(0.05 * (((taxCalculationData.getMonthlySalary() + taxCalculationData.getOtherMonthlyIncome()) * taxCalculationData.getNumberOfMonthWorking()) - taxCalculationData.getDeductible() - (54000000 + 4500000 + (numberOfChildren * 1500000))));
        } else {
            tax = (int) Math.round(0.05 * (((taxCalculationData.getMonthlySalary() + taxCalculationData.getOtherMonthlyIncome()) * taxCalculationData.getNumberOfMonthWorking()) - taxCalculationData.getDeductible() - 54000000));
        }

        return Math.max(tax, 0);
    }
}