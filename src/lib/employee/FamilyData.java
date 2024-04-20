package lib.employee;

import java.util.LinkedList;
import java.util.List;

public class FamilyData {
    private Name spouseName;
    private IdNumber spouseIdNumber;
    private List<Name> childNames;
    private List<IdNumber> childIdNumbers;

    public FamilyData() {
        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public Name getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(Name spouseName) {
        this.spouseName = spouseName;
    }

    public IdNumber getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(IdNumber spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public List<Name> getChildNames() {
        return childNames;
    }

    public List<IdNumber> getChildIdNumbers() {
        return childIdNumbers;
    }

    public void addChild(Name childName, IdNumber childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }
}