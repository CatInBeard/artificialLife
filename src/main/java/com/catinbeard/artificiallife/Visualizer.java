/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Visualizer extends JFrame implements FieldObserver {
    
    protected JPanel drawingPanel; 
    private Field field;
    
    public Visualizer() {
        super("Artifical life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };

        setContentPane(drawingPanel);

        setSize(800, 600);
        setVisible(true);

    }
    
    protected void draw(Graphics g){
        drawField(g);
    }
    
    protected void drawField(Graphics g){
        Dimension size = getContentPane().getSize();
        int width = size.width;
        int height = size.height;

        int numCellsX = field.getSizeX();
        int numCellsY = field.getSizeY();

        float cellWidth = width / numCellsX;
        float cellHeight = height / numCellsY;

        for (int x = 0; x < numCellsX; x++) {
            g.drawLine( (int) (x * cellWidth), 0, (int) (x * cellWidth), height);
        }

        for (int y = 0; y < numCellsY; y++) {
            g.drawLine(0, (int) (y * cellHeight), width, (int) (y * cellHeight));
        }
        g.setColor(Color.RED);
        g.drawString(width + " " + height, 10, 50);
    }
    
    public void UpdateField(Field field){
        this.field = field;
        drawingPanel.repaint(); 
    }
}
