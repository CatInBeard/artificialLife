/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public final class Game {

    protected Visualizer visualizer;
    protected Field field;
    protected double grassRate;
    protected double rabbitRate;
    protected double wolfRate;

    
    public Game(int size){
        this(size, 0.3, 0.05, 0.01);
    }
    public Game(){
        this(20);
    }
    
    public Game(int size, double grass, double rabbit, double wolf) {
        grassRate = grass;
        rabbitRate = rabbit;
        wolfRate = wolf;
        visualizer = new Visualizer();
        field = new Field(size, size);
        field.addObserver(visualizer);
        
        initField();
    }
    
    private void initField(){
        Random random = new Random();
        try {
            for (int i = 0; i < field.getSizeX(); i++) {
                for (int j = 0; j < field.getSizeY(); j++) {
                    if(random.nextDouble() < grassRate)
                    field.insertObject(i, j, new Grass());
                }   
            }
            for (int i = 0; i < field.getSizeX(); i++) {
                for (int j = 0; j < field.getSizeY(); j++) {
                    if(random.nextDouble() < rabbitRate)
                    field.insertObject(i, j, new Rabbit());
                }
            }
            for (int i = 0; i < field.getSizeX(); i++) {
                for (int j = 0; j < field.getSizeY(); j++) {
                    if(random.nextDouble() < wolfRate)
                    field.insertObject(i, j, new Wolf());
                }
            }

        } catch (IOException e) {
        }
    }
    
    public void run(){
        run(50);
    }
    
    public void run(double tps){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            computeStep();
        }, 0, (long) (1000/tps), TimeUnit.MILLISECONDS);
    }
    
    private void computeStep(){
        Drawable[][] objects = field.getObjects();
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                ObjectLogic object = (ObjectLogic) objects[i][j];
                if(object == null)
                        continue;
                
                if(!object.decreaseEnergyByTurn()){
                    field.insertObject(i,j,null);
                }
                
            }
        }
    }
    
}
