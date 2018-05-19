package coreJava.inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee>,Cloneable{
    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String name, double salary,int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year,month,day);
    }

    public Employee(String name, double salary,LocalDate hireDate){
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public void raiseSalary(double byPercent){
        this.salary += this.salary*(this.salary*byPercent/100);
    }

    @Override
    public boolean equals(Object otherObject) {
        //检测this是否与otherObjects引用同一对象
        if(super.equals(otherObject)){return true;}

//        //necessary judgement->if otherObjects equals null, return false
//        if(otherObject == null) {return false;}
//        if(this.getClass() != otherObject.getClass()){return false;}
        //比较this 与otherObjects是否是同一个类(Runtime Class)仅限语意明确时使用
        if( otherObject instanceof Employee) {
            //将otherObject类型转化为此类,进行成员变量(域)的比较
            Employee otherEmployee = (Employee) otherObject;
            //最好使用Objects.equals替代this.name.equals，防止空指针异常
            return Objects.equals(this.name, otherEmployee.name) //this.name.equals(otherEmployee.name)
                    && this.salary == otherEmployee.salary
                    && Objects.equals(this.hireDate, otherEmployee.hireDate);//this.hireDate.equals(otherEmployee.hireDate);
        }else{
            return Boolean.FALSE;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, new Double(this.salary),this.hireDate);
//        return 7 * Objects.hashCode(this.name)
//                + 11 * Objects.hashCode(this.hireDate)
//                + 13 * Objects.hashCode(new Double(this.salary));
    }

    @Override
    public String toString() {
        return this.getClass().getName()
                +"[name = "+ (this.name == null? "":this.name)
                +", salary = "+this.salary
                +", hireDate = "+(this.hireDate == null? "--":this.hireDate.toString())
                +" ]";
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary,other.salary);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
        //if type of hireDate is java.util.Date which is a changeable object, then
        //Employee employee = (Employee) super.clone();
        //employee.hireDate = (Date) this.hireDate.clone();
        //return employee;
    }
}