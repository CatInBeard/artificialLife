/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import static com.catinbeard.artificiallife.Rabbit.INITIAL_ENERGY;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Wolf extends AIObject {
    
    public static final int ENERGY_DECREASE_BY_TURN = 5;
    public static final int INITIAL_ENERGY = 50;
    
    public Wolf() throws IOException{
        setSVGPath("/images/wolf.svg");
        energyDecreaseByTurn = ENERGY_DECREASE_BY_TURN;
        setEnergy(INITIAL_ENERGY);
    }
    
}
