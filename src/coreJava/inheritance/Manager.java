package coreJava.inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Manager extends Employee {

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    public Manager(String name, double salary,LocalDate hireDate){
        super(name,salary,hireDate);
        this.bonus = 0;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if(!(super.equals(otherObject))){
            return false;
        }else{
            Manager otherManager = (Manager) otherObject;
            return this.bonus == otherManager.bonus;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(new Double(this.bonus));
    }

    @Override
    public String toString() {
        return super.toString() + "[ bonus = "+this.bonus+"]";
    }

    @Override
    public int compareTo(Employee other) {
        if(other instanceof Manager){   //instance of Manager
            Manager otherManager = (Manager) other;
            return Double.compare(this.bonus,otherManager.bonus);
        }else{  //instance of Employee
            return Double.compare(super.getSalary(),other.getSalary());
        }
    }
}
