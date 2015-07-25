package br.com.idtrust.examples.mongodb.test;

import br.com.idtrust.examples.mongodb.EmployeeService;
import br.com.idtrust.examples.mongodb.entity.Employee;
import org.junit.Test;

public class EmployeeServiceTestCase {

    @Test
    public void shouldSaveEmployee() {
        EmployeeService employeeService = new EmployeeService();

        Employee manager = new Employee("00000000000", "BOSS", null, null, 100000d);
        employeeService.addEmployee(manager);

        Employee employee = new Employee("11111111111", "CRISTIANO ANDRADE", manager, null, 100d);
        employeeService.addEmployee(employee);

        Employee result = employeeService.getEmployee("11111111111");

        System.out.println(result);
    }

}
