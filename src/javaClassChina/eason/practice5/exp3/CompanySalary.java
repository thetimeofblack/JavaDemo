package javaClassChina.eason.practice5.exp3;

public class CompanySalary {
    public static void main(String[] args) {
        Employee[] employees = new Employee[29];
        for (int i = 0; i < employees.length; i++) {
            if(i%3 == 0){
                employees[i] = new WeekWorker();
            }else if(i%3 == 1){
                employees[i] = new MonthWorker();
            }else{
                employees[i] = new YearWorker();
            }
        }
        Company company = new Company(employees);
        System.out.println("公司薪水总额:"+company.salariesPay()+"元");
    }
}
