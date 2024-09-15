/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.util.LinkedList;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Field {
    private final int sizeX;
    private final int sizeY;
    private final LinkedList<FieldObserver> observers;
    private final Drawable[][] objects;
    
    public Field(int X, int Y){
        sizeX = X;
        sizeY = Y;
        observers = new LinkedList<>();
        objects = new Drawable[sizeX][sizeY];
    }
    
    public int getSizeX(){
        return sizeX;
    }
    
    public int getSizeY(){
        return sizeY;
    }
    
    public void triggerObservers(){
        for (FieldObserver observer : observers) {
            observer.UpdateField(this);
        }
    }
    
    public void addObserver(FieldObserver fieldObserver){
        observers.add(fieldObserver);
        fieldObserver.UpdateField(this);
    }
    
    public Drawable[][] getObjects(){
        return objects;
    }
    
    public void insertObject(int x, int y, Drawable d){
        objects[x][y] = d;
        triggerObservers();
    }
}
