/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.io.IOException;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Game {

    protected Visualizer visualizer;
    protected Field field;

    public Game() {

        int size = 50;

        visualizer = new Visualizer();
        field = new Field(size, size);
        field.addObserver(visualizer);
        
        initField();
    }
    
    protected void initField(){
        try {
            for (int i = 0; i < field.getSizeX(); i++) {
                for (int j = 0; j < field.getSizeY(); j++) {
                    if((i+j) % 2 == 0)
                    field.insertObject(i, j, new Grass());
                }
            }

        } catch (IOException e) {
        }
    }
    
}
