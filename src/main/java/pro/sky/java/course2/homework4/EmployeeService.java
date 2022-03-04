package pro.sky.java.course2.homework4;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    Employee[] employees = new Employee[4];

    public Employee addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return employees[i];
            }
        }
        return null;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            Employee employeeToRemove = null;
            if (employees[i] != null && (employees[i].getFirstName().equals(firstName) &&
                    employees[i].getLastName().equals(lastName))) {
                employeeToRemove = employees[i];
                employees[i] = null;
                return employeeToRemove;
            }
        }
        return null;
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && (employees[i].getFirstName().equals(firstName) &&
                    employees[i].getLastName().equals(lastName))) {
                return employees[i];
            }
        }
        return null;
    }
}

