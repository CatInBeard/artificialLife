/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;


/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Game {
    protected Visualizer visualizer;
    protected Field field;
    public Game() {
        
        visualizer = new Visualizer();
        field = new Field(5,5);
        field.addObserver(visualizer);
        
    }
}
