/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.catinbeard.artificiallife;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Grigoriy Efimov <efimov-gm@newpage.xyz>
 */
public class Artificiallife {

    public static void main(String[] args) {
        
        Settings settings = new Settings();
        
        while (settings.isVisible()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.exit(0);
            }
        }
        
        int size = settings.size;
        double grassRate = ((double) (settings.grassRate)) / 100;
        double rabbitRate = ((double) (settings.rabbitRate)) / 100;
        double wolfRate = ((double) (settings.wolfRate)) / 100;
        
        settings.dispose(); 
        
        
        Game game = new Game(size, grassRate, rabbitRate, wolfRate);
        game.run();
    }
}
