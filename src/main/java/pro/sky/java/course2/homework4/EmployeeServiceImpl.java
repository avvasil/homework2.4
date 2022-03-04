package pro.sky.java.course2.homework4;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Employee[] employees = new Employee[4];
    int size;

    public Employee addEmployee(String firstName, String lastName) {

        if (employees.length == size) {
            throw new EmployeeArrayOverflowException("Массив переполнен");
        }
        Employee addingEmployee = new Employee(firstName, lastName);
        int addingEmployeeIndex = getEmployeeIndex(addingEmployee);

        if (addingEmployeeIndex != -1) {
            throw new EmployeeAlreadyExistsException("Этот работник уже добавлен");
        }
        employees[size++] = addingEmployee;
        return addingEmployee;

    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);
        int employeeIndex = getEmployeeIndex(removingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        Employee removedEmployee = employees[employeeIndex];
        System.arraycopy(employees, employeeIndex + 1, employees, employeeIndex, size - employeeIndex);
        size--;
        return removedEmployee;

    }

    private int getEmployeeIndex(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employee.equals(employees[i])) {
                return i;
            }
        }
        return -1;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee findingEmployee = new Employee(firstName, lastName);
        int employeeIndex = getEmployeeIndex(findingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employees[employeeIndex];

    }
}

