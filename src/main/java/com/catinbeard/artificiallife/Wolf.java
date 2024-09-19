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
public class Wolf implements Drawable {
    
    private static BufferedImage image;
    
    public Wolf() throws IOException{
        if (image == null) {
            image = ImageIO.read(getClass().getResource("/images/wolf.svg"));
        }
    }
    
    public BufferedImage getImage(){
        return image;
    }
}
