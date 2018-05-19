package coreJava.chapter4;

import java.util.Date;

public class Employee implements Comparable<Employee> {

    private Date hireDate;
    private String name;
    private final int id;       //id is unchangeable.

    public Employee(Date hireDate, String name, int id){
        this.hireDate = hireDate;
        this.name = name;
        this.id = id;
    }

    public Date getHireDate() {
        return (Date) this.hireDate.clone();
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printInfo(){
        System.out.println("hiredate= "+hireDate+" name= "+this.name+" id= "+this.id);
    }

//    @Override
//    public String toString() {
//        StringBuilder writer = new StringBuilder().append("My name is").append(this.name);
//        writer.append(" and my hire date is ").append(this.hireDate.toString());
//        return writer.toString();
//    }
    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int compareTo(Employee employee) {
        return 0;
    }
}
