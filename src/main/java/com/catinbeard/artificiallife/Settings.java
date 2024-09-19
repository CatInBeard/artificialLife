package com.catinbeard.artificiallife;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Settings extends JFrame {

    private JPanel panel;
    private JTextField sizeField, grassRateField, rabbitRateField, wolfRateField;
    public int size, grassRate, rabbitRate, wolfRate;

    public Settings() {
        super("Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new GridLayout(5, 2));

        contentPane.add(new JLabel("Size"));
        sizeField = new JTextField();
        contentPane.add(sizeField);

        contentPane.add(new JLabel("Grass rate %"));
        grassRateField = new JTextField();
        contentPane.add(grassRateField);

        contentPane.add(new JLabel("Rabbit rate %"));
        rabbitRateField = new JTextField();
        contentPane.add(rabbitRateField);

        contentPane.add(new JLabel("Wolf rate %"));
        wolfRateField = new JTextField();
        contentPane.add(wolfRateField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener((ActionEvent e) -> {
            try {
                size = Integer.parseInt(sizeField.getText());
                grassRate = Integer.parseInt(grassRateField.getText());
                rabbitRate = Integer.parseInt(rabbitRateField.getText());
                wolfRate = Integer.parseInt(wolfRateField.getText());

                if ((grassRate > 100 || grassRate < 0)
                        & (rabbitRate > 100 || rabbitRate < 0)
                        & (wolfRate > 100 || wolfRate < 0)) {
                    JOptionPane.showMessageDialog(null, "Values must be from 1 to 100!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    setVisible(false);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please fill all fields with numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(okButton);

        add(contentPane);
        setVisible(true);
    }

    public void addWindowCloseListener(WindowListener listener) {
        addWindowListener(listener);
    }

}
