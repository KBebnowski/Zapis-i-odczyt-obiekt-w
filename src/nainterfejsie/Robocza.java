package nainterfejsie;

import javax.swing.*;
import java.awt.*;

public class Robocza extends JFrame {

private JTextPane textPane;
private  Button btn;

   public Robocza(){
       super("Hello");

       setLayout(new BorderLayout());

        textPane = new JTextPane();

        btn = new Button();

        add(textPane, BorderLayout.NORTH);
        add(btn, BorderLayout.SOUTH);

       Student a1 = new Student("ala", "nogal", 1, "5");
       a1.setOcena(textPane.getText());


/*
       Student a2 = new Student("Emilka", "Franek", 2);
       a2.setOcen(2, "sprawdzian");
       a2.setOcen(3, "kartkowka");

       a1.setOcen() = textPane.getText();
*/


       setSize(600,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);

   };

}
