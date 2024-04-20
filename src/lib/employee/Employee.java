package lib.employee;

import java.time.LocalDate;

import lib.tax.MaritalStatus;
import lib.tax.TaxFunction;

public class Employee {
    private EmployeeData employeeData;
    private FamilyData familyData;
    private int monthWorkingInYear;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Employee(EmployeeData employeeData) {
        this.employeeData = employeeData;
        this.familyData = new FamilyData();
    }

    public void setMonthlySalary(int grade) {
        int baseSalary;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }

        if (employeeData.getEmployeeType() == EmployeeType.FOREIGN) {
            monthlySalary = (int) (baseSalary * 1.5);
        } else {
            monthlySalary = baseSalary;
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(Name spouseName, IdNumber spouseIdNumber) {
        familyData.setSpouseName(spouseName);
        familyData.setSpouseIdNumber(spouseIdNumber);
    }

    public void addChild(Name childName, IdNumber childIdNumber) {
        familyData.addChild(childName, childIdNumber);
    }

    public int getAnnualIncomeTax() {
        // Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();
    
        if (date.getYear() == employeeData.getJoinDate().getYear()) {
            monthWorkingInYear = date.getMonthValue() - employeeData.getJoinDate().getMonthValue();
        } else {
            monthWorkingInYear = 12;
        }
    
        MaritalStatus maritalStatus = familyData.getSpouseIdNumber() == null ? MaritalStatus.SINGLE : MaritalStatus.MARRIED;
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, maritalStatus, familyData.getChildIdNumbers().size());
    }
}