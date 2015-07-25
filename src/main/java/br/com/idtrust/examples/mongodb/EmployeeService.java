package br.com.idtrust.examples.mongodb;

import br.com.idtrust.examples.mongodb.entity.Employee;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;


import java.util.List;

public class EmployeeService {

    public void addEmployee(final Employee employee) {
        Datastore.getInstance().save(employee);
    }

    public Employee getEmployee(final String cpf) {
        return Datastore.getInstance().find(Employee.class, "cpf", cpf).get();
    }

    public void addDirectReports(Employee employee, List<Employee> directReports) {
        UpdateOperations<Employee> updateOperations =
                Datastore.getInstance()
                        .createUpdateOperations(Employee.class)
                        .add("directReports", directReports);
        Datastore.getInstance().update(employee, updateOperations);
    }
}
