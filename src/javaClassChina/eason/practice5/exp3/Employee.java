package javaClassChina.eason.practice5.exp3;

abstract class Employee {
    public abstract double earnings();
}
class YearWorker extends Employee{
    @Override
    public double earnings() {
        return 12000;
    }
}
class MonthWorker extends Employee{
    @Override
    public double earnings() {
        return 12*2300;
    }
}
class WeekWorker extends Employee{
    @Override
    public double earnings() {
        return 52*780;
    }
}
class Company{
    private Employee[] employees;
    private double salaries = 0;
    Company(Employee[] employees){
        this.employees = employees;
    }
    public double salariesPay(){
        this.salaries = 0;
        for (int i = 0; i < employees.length; i++) {
            this.salaries += employees[i].earnings();
        }
        return this.salaries;
    }
}
