package presentation;

import javax.swing.*;
import java.awt.*;

public class Receipt extends JFrame {
    public Receipt(int x) {
        JLabel mesaj = new JLabel();
        this.setLayout(null);
        this.setBounds(550, 300, 400, 200);
        this.getContentPane().setBackground(new Color(0, 200, 255));
        this.setTitle("Receipt");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String s="The price is "+x;
        mesaj = new JLabel(s);
        mesaj.setBounds(70, 10, 300, 100);
        mesaj.setFont(new Font("Georgia", Font.BOLD, 25));
        mesaj.setForeground(new Color(0, 0, 0));
        this.add(mesaj);

        this.setVisible(true);
    }
}
