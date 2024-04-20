package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private Name name;
    private IdNumber idNumber;
    private String address;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;
    private EmployeeType employeeType;
    private Gender gender;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private Name spouseName;
    private IdNumber spouseIdNumber;
    private List<Name> childNames;
    private List<IdNumber> childIdNumbers;

    public Employee(String employeeId, Name name, IdNumber idNumber, String address, int yearJoined, int monthJoined, int dayJoined, EmployeeType employeeType, Gender gender) {
        this.employeeId = employeeId;
        this.name = name;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.employeeType = employeeType;
        this.gender = gender;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
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

        if (employeeType == EmployeeType.FOREIGN) {
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
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(Name childName, IdNumber childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        // Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();

        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber == null, childIdNumbers.size());
    }
}