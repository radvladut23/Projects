package presentation;

import javax.swing.*;
import java.awt.*;

public class ExceptionFr extends JFrame {
    public ExceptionFr() {
        JLabel mesaj=new JLabel();
        this.setLayout(null);
        this.setBounds(550, 300, 400, 200);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setTitle("Incorrect data!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mesaj=new JLabel("Incorrect data!");
        mesaj.setBounds(70,10,300,100);
        mesaj.setFont(new Font("Georgia", Font.BOLD,30));
        mesaj.setForeground(new Color(255,0,0));
        this.add(mesaj);

        this.setVisible(true);

    }
}
