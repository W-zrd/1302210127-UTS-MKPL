package lib;

import java.time.LocalDate;

import lib.employee.Employee;
import lib.employee.EmployeeData;
import lib.employee.EmployeeType;
import lib.employee.Gender;
import lib.employee.IdNumber;
import lib.employee.Name;

public class Driver {
    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData("E001", new Name("Rafidhia", "Haikal"), new IdNumber("123456789"), "Jl. Example No. 123", LocalDate.of(2022, 1, 1), EmployeeType.LOCAL, Gender.MALE);
        Employee employee = new Employee(employeeData);
        employee.setMonthlySalary(1);
        employee.setAnnualDeductible(1000000);
        employee.setAdditionalIncome(500000);
        employee.setSpouse(new Name("Rafidhia", "Haikal"), new IdNumber("987654321"));
        employee.addChild(new Name("w333zard", ""), new IdNumber("111111111"));
        employee.addChild(new Name("Child", "Two"), new IdNumber("222222222"));

        int annualIncomeTax = employee.getAnnualIncomeTax();
        System.out.println("Annual Income Tax: " + annualIncomeTax);
    }
}