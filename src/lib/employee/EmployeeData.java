package lib.employee;

import java.time.LocalDate;

public class EmployeeData {
    private String employeeId;
    private Name name;
    private IdNumber idNumber;
    private String address;
    private LocalDate joinDate;
    private EmployeeType employeeType;
    private Gender gender;

    public EmployeeData(String employeeId, Name name, IdNumber idNumber, String address, LocalDate joinDate, EmployeeType employeeType, Gender gender) {
        this.employeeId = employeeId;
        this.name = name;
        this.idNumber = idNumber;
        this.address = address;
        this.joinDate = joinDate;
        this.employeeType = employeeType;
        this.gender = gender;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Name getName() {
        return name;
    }

    public IdNumber getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Gender getGender() {
        return gender;
    }
}