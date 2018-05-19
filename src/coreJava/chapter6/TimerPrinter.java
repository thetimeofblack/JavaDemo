package coreJava.chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.function.IntConsumer;

public final class TimerPrinter implements ActionListener {

    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();

        Timer timer1 = new Timer(1000,(event)->{
            System.out.println("At the tone, the time is" + new Date());
            Toolkit.getDefaultToolkit().beep();
        });

        Timer timer2 = new Timer(1000,System.out::println);

        TimerPrinter.repeat(5,()-> System.out.println("Hello World"));

        TimerPrinter.improvedRepeat(5,(i)-> System.out.println("Countdown:"+(9-i)));

        //construct a timer that calls the listener
        //once every 10 seconds
//        javax.swing.Timer timer = new Timer(10000,listener);
//        timer.start();
//        JOptionPane.showMessageDialog(null,"Quit Program?");
    }

    /**
     * print the message{@see message} repeatedly in every millionSeconds
     * */
    public void repeatMessage(int millionSeconds,String message){
        ActionListener listener = event -> {
            System.out.println(message);
            System.out.println(this.toString());
        };
        new Timer(millionSeconds,listener).start();
    }

    /**
     * repeat one sentence for {@see times} times
     * For example: TimerPrinter.repeat(5,()-> System.out.println("Hello World"));
     * the console will print "Hello World" for five times
     * */
    public static void repeat(int times,Runnable action){
        for (int i = 0; i < times; i++) {
            action.run();
        }
    }

    /**
     * repeat one sentence for {@see times} times
     * For example: TimerPrinter.repeat(5,()-> System.out.println("Hello World"));
     * the console will print "Hello World" for five times
     * */
    public static void improvedRepeat(int times,IntConsumer action){
        for (int i = 0; i < times; i++) {
            action.accept(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is" + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
