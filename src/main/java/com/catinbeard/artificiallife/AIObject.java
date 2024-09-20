/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public abstract class AIObject extends Drawable implements ObjectLogic {
    protected int energyDecreaseByTurn = 1;
    protected int energy;
    @Override
    public boolean decreaseEnergyByTurn(){
        energy = energy - energyDecreaseByTurn;
        return energy > 0;
    }
    @Override
    public int getEnergy(){
        return energy;
    }
    protected void setEnergy(int e){
        energy = e;
    }
}
