package pro.sky.java.course2.homework4;

public interface EmployeeService {

    Employee addEmployee (String firstName, String lastName);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
}
