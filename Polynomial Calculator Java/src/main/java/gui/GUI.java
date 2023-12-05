package gui;
import javax.swing.text.JTextComponent;

import polinom.OPERATII;
import polinom.POLYNOM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton adunare = new JButton("Adunare");
        JButton impartire = new JButton("Impartire");
        JButton scadere = new JButton("Scadere");
        JButton derivare = new JButton("Derivare");
        JButton integrare = new JButton("Integrare");
        JButton inmultire = new JButton("Inmultire");
        JTextField polinom1 = new JTextField();
        JTextField polinom2 = new JTextField();
        JLabel rezultat = new JLabel("Rezultat");
        JLabel rezultat1 = new JLabel("Polinom 1");
        JLabel rezultat2 = new JLabel("Polinom 2");
        JLabel rezultat3 = new JLabel("Integrarea si Derivarea se fac pentru Polinom 1");

        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        frame.setSize(1024, 980);
        panel.setLayout(new GridLayout(0, 2));
        panel.add(rezultat1);
        panel.add(rezultat2);
        panel.add(polinom1);
        panel.add(polinom2);
        panel.add(adunare);
        panel.add(scadere);
        panel.add(inmultire);
        panel.add(impartire);
        panel.add(derivare);
        panel.add(integrare);
        panel.add(rezultat);
        panel.add(rezultat3);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);

        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POLYNOM polinoma = new POLYNOM();
                POLYNOM polinomb = new POLYNOM();
                polinoma = polinoma.regex(polinom1.getText());
                polinomb = polinomb.regex(polinom2.getText());
                POLYNOM rezultatop = new POLYNOM();
                OPERATII op = new OPERATII();
                rezultatop = op.adunare(polinoma, polinomb);
                rezultat.setText(rezultatop.afisare(rezultatop));

            }
        });

        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POLYNOM polinoma = new POLYNOM();
                POLYNOM polinomb = new POLYNOM();
                polinoma = polinoma.regex(polinom1.getText());
                polinomb = polinomb.regex(polinom2.getText());
                POLYNOM rezultatop = new POLYNOM();
                OPERATII op = new OPERATII();
                rezultatop = op.inmultire(polinoma, polinomb);
                rezultat.setText(rezultatop.afisare(rezultatop));

            }
        });
       derivare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POLYNOM polinoma = new POLYNOM();
                polinoma = polinoma.regex(polinom1.getText());
                POLYNOM rezultatop = new POLYNOM();
                OPERATII op = new OPERATII();
                rezultatop = op.derivare(polinoma);
                rezultat.setText(rezultatop.afisare(rezultatop));

            }
        });
        integrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POLYNOM polinoma = new POLYNOM();
                polinoma = polinoma.regex(polinom1.getText());
                POLYNOM rezultatop = new POLYNOM();
                OPERATII op = new OPERATII();
                rezultatop = op.integrare(polinoma);
                rezultat.setText(rezultatop.afisare(rezultatop));

            }
        });
        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POLYNOM polinoma = new POLYNOM();
                POLYNOM polinomb = new POLYNOM();
                polinoma = polinoma.regex(polinom1.getText());
                polinomb = polinomb.regex(polinom2.getText());
                POLYNOM rezultatop = new POLYNOM();
                OPERATII op = new OPERATII();
                rezultatop = op.scadere(polinoma, polinomb);
                rezultat.setText(rezultatop.afisare(rezultatop));

            }
        });


    }
}
