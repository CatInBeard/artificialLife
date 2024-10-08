/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Grass extends Drawable implements ObjectLogic {
    
    public static final int GRASS_ENERGY = 100;
    
    public Grass() throws IOException{
        setSVGPath("/images/grass.svg");
    }
    
    
    public boolean decreaseEnergyByTurn(){
        return true;
    }
    
    public int getEnergy(){
        return GRASS_ENERGY;
    }
    
}
