package coreJava.inheritance;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class TestEmp {
    public static void main(String[] args) {
        Employee emp1 = new Employee("African",1000,null);
        Employee emp2 = new Employee("Jason",10000, LocalDate.now());


        Manager manager = new Manager("Jason",10000, null);
        try {
            Employee employee = emp1.clone();
            Employee[] employees = {emp1,emp2,manager};
            Arrays.sort(employees, (em1,em2)-> em1.getName().length()-em2.getName().length());
            Arrays.sort(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.compareTo(emp1);
        Employee emp3 = emp1;
        System.out.println(manager);
        System.out.println(emp1.hashCode());
        System.out.println(emp2);
        System.out.println(emp1.equals(emp2));
        System.out.println(Objects.equals(emp1,emp3));
    }
}