/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.catinbeard.artificiallife;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public abstract class Drawable {
    private static final Map<Drawable, BufferedImage> image = new HashMap<>();
    
    public BufferedImage getImage(){
        return image.get(this);
    }
    
    protected void setSVGPath(String path) throws IOException{
        if (image.get(this) == null) {
            image.put(this,ImageIO.read(getClass().getResource(path)));
        }
    }
    
}
