package br.com.idtrust.examples.mongodb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

@Entity("employees")
@Indexes(
        @Index(value = "cpf", fields = @Field("cpf"))
)
public class Employee {
    @Id
    private ObjectId id;
    private String cpf;
    private String name;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports;
    @Property("salary")
    private Double salary;

    public Employee() {
    }

    public Employee(String cpf, String name,
                    Employee manager, List<Employee> directReports,
                    Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.manager = manager;
        this.directReports = directReports;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", directReports=" + directReports +
                ", salary=" + salary +
                '}';
    }
}