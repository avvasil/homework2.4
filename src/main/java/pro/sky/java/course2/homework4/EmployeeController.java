package pro.sky.java.course2.homework4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService addEmployee;
    private final EmployeeService removeEmployee;
    private final EmployeeService findEmployee;


    public EmployeeController(EmployeeService addEmployee, EmployeeService removeEmployee, EmployeeService findEmployee) {
        this.addEmployee = addEmployee;
        this.removeEmployee = removeEmployee;
        this.findEmployee = findEmployee;
    }


    @RequestMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (addEmployee.addEmployee(firstName, lastName) == null) {
            throw new EmployeeArrayOverflowException("Массив переполнен");
        }
        return addEmployee.addEmployee(firstName, lastName);
    }

    @RequestMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (removeEmployee.removeEmployee(firstName, lastName) == null) {
            throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
        }
        return removeEmployee.removeEmployee(firstName, lastName);
    }

    @RequestMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (findEmployee.findEmployee(firstName, lastName) == null) {
            throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
        }
        return findEmployee.findEmployee(firstName, lastName);
    }

}
