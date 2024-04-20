package lib;

public class Driver {
    public static void main(String[] args) {
        Employee employee = new Employee("E001", new Name("John", "Doe"), new IdNumber("123456789"), "Jl. Example No. 123", 2022, 1, 1, EmployeeType.LOCAL, Gender.MALE);
        employee.setMonthlySalary(1);
        employee.setAnnualDeductible(1000000);
        employee.setAdditionalIncome(500000);
        employee.setSpouse(new Name("Jane", "Doe"), new IdNumber("987654321"));
        employee.addChild(new Name("Child", "One"), new IdNumber("111111111"));
        employee.addChild(new Name("Child", "Two"), new IdNumber("222222222"));

        int annualIncomeTax = employee.getAnnualIncomeTax();
        System.out.println("Annual Income Tax: " + annualIncomeTax);
    }
}