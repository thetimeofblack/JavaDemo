package coreJava.chapter6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ActionListenerLambda {

    public static void main(String[] args) {
        //before Java 8
        JButton button = new JButton("show");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        //Java 8  using lambda
        button.addActionListener( (event) ->
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks")
        );
    }
}