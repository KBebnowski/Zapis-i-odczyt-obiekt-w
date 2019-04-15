package nainterfejsie;

import javax.swing.*;

public class interfejs {
    private JTextPane textPane1;
    private JButton button1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Robocza();
            }
        });
    }
}
