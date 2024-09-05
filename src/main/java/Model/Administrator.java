package Model;

import Model.Interfaces.Manageable;

import java.util.HashMap;

public class Administrator extends Person implements Manageable {
    private String department;
    private HashMap<String, Integer> departmentStaffCount;//Map department names to the number of staff members in each department.
    // Static final variable
    public static final String role = "Administrator";

    // Constructor
    public Administrator(String name, int age, String department) {
        super(name, age);
        this.department = department;
        this.departmentStaffCount = new HashMap<>();
    }

    // Implement Manageable interface method

    public void manage() {
        System.out.println("Administrator " + getName() + " is managing the " + department + " department.");
    }

    // Implement performDuties from Person
    @Override
    public void performDuties() {
        System.out.println("Performing administrative duties in the " + department + " department.");
    }


    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addDepartmentStaff(String department, int count) {
        departmentStaffCount.put(department, count);
        System.out.println("Added staff to department: " + department + ", Count: " + count);
    }

    public HashMap<String, Integer> getDepartmentStaffCount() {
        return departmentStaffCount;
    }
}