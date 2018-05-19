package coreJava.chapter4;

import java.time.LocalDate;

/**
 *  @author Eason.Hua ContactMe:easonhua0216@gmail.com
 *  Mon Tue Wed Thu Fri Sat Sun
 *                  1   2   3
 *   4   5   6   7   8   9  10
 *   11  12  13  14  15  16  17
 *   18  19  20  21  22  23  24*
 *   25  26  27  28  29  30
 *
 *
 * */
public final class MyCalendar{

    //unit test
    public static void main(String[] args) {
        MyCalendar.printToday();
        MyCalendar.printDate(2017,4,25);
    }

    /**
     *
     * */
    private static LocalDate date = null;

    /**
     * general method to print formalized calendar.
     * make it private so that cannot be used outside.
     * */
    private static void printDate(){
        //根据成员localDate输出格式化的日期.
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //return to the first day of the month.
        date = date.minusDays(today -1);
        //1=Monday,2=Tuesday,3=Wednesday,4=Thursday,5=Friday,6=Saturday,7=Sunday.
        int value = date.getDayOfWeek().getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        //print blanks for the first line
        for (int i = 0 ; i < ( value-1 ) ; i++) {
            System.out.print("    ");
        }
        while(date.getMonthValue() == month){
            // date is in this month
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            date = date.plusDays(1);    //add the date
            if(date.getDayOfWeek().getValue() == 1){    //at the beginning of the week, a new line
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }

    /**
     * print today in month calendar
     * */
    public static void printToday(){
        date = LocalDate.now();
        MyCalendar.printDate();
    }

    /**
     * print certain formalized calendar in the selected date.
     * @param year year time of certain day
     * @param month
     * */
    public static void printDate(int year, int month, int day){
        date = LocalDate.of(year, month, day);
        MyCalendar.printDate();
    }
}