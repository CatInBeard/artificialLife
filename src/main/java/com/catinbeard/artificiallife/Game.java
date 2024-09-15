/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Game {

    protected Visualizer visualizer;
    protected Field field;
    protected double grassRate;

    public Game(int size){
        this(size, 0.1);
    }
    public Game(){
        this(20);
    }
    
    public Game(int size, double grass) {
        grassRate = grass;
        visualizer = new Visualizer();
        field = new Field(size, size);
        field.addObserver(visualizer);
        
        initField();
    }
    
    protected void initField(){
        Random random = new Random();
        try {
            for (int i = 0; i < field.getSizeX(); i++) {
                for (int j = 0; j < field.getSizeY(); j++) {
                    if(random.nextDouble() < grassRate)
                    field.insertObject(i, j, new Grass());
                }
            }

        } catch (IOException e) {
        }
    }
    
}
