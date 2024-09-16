package Model.Classes;

import Model.Enums.Department;
import Model.Interfaces.Manageable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Administrator extends Person implements Manageable {

    private static final Logger logger = LogManager.getLogger(Administrator.class);
    private HashMap<String, Integer> departmentStaffCount;//Map department names to the number of staff members in each department.
    // Static final variable
    public static final String role = "Administrator";
    private Department department; // Enum as an attribute


    // Constructor
    public Administrator(String name, int age, Department department) {
        super(name, age);
        this.department = department;
        this.departmentStaffCount = new HashMap<>();
        logger.info("Administrator created: " + name + ", Department: " + department);
    }

    // Implement Manageable interface method

    public void manage() {
        logger.info("Administrator " + getName() + " is managing the " + department + " department.");
    }

    // Implement performDuties from Person
    @Override
    public void performDuties() {
        logger.info("Performing administrative duties in the " + department + " department.");

    }


    // Getter and Setter for department


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addDepartmentStaff(String department, int count) {
        departmentStaffCount.put(department, count);
        logger.info("Added staff to department: " + department + ", Count: " + count);

    }

    public HashMap<String, Integer> getDepartmentStaffCount() {

        return departmentStaffCount;
    }
}