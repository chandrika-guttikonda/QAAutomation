package tests.Day13_AccessModifiersStaticFinalUsage;

import java.util.ArrayList;

public class EmployeeDatabaseSimulation {
	 // Static method to find and print the employee with the highest salary
    public static void findHighestSalaryEmployee(ArrayList<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }

        Employee highest = employees.get(0); // start by assuming first employee is highest

        for (Employee e : employees) {
            if (e.getSalary() > highest.getSalary()) {
                highest = e;
            }
        }

        System.out.println("\n Employee with highest salary:");
        System.out.println("ID: " + highest.getId());
        System.out.println("Salary: " + highest.getSalary());
        System.out.println("Company: " + Employee.Company); // static final field
    }

    // Main method
    public static void main(String[] args) {
        // Step 1: Create ArrayList of Employee
        ArrayList<Employee> employees = new ArrayList<>();

        // Step 2: Add employees using parameterized constructor
        Employee emp1 = new Employee(101, "Alice", 60000);
        Employee emp2 = new Employee(102, "Bob", 75000);
        Employee emp3 = new Employee(103, "Charlie", 50000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // Step 3: Print details of all employees
        System.out.println(" All Employees:");
        for (Employee e : employees) {
            System.out.println("ID: " + e.getId() +
                               ", Salary: " + e.getSalary() +
                               ", Company: " + Employee.Company);
        }

        // Step 4: Update salary of one employee (Bob)
        emp2.setSalary(80000);

        // Step 5: Print updated details
        System.out.println("\n After salary update:");
        for (Employee e : employees) {
            System.out.println("ID: " + e.getId() +
                               ", Salary: " + e.getSalary() +
                               ", Company: " + Employee.Company);
        }

        // Step 6: Find employee with highest salary using static method
        findHighestSalaryEmployee(employees);
    }
}
