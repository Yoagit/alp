package org.raoul.alp;

import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.position.Position2D;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.sensor.Around;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.view.Flat2DFrame;

public class Application {
    public static void main(String[] args) {

        Set<Sens> senses = new HashSet<>();

        senses.add(new Around(100));
        
        for(int i = 0; i < 10; i++){
            Playground.addLifeform(new Sensed(100, new Position2D(Math.random()*300 + 100, Math.random()*300 + 100), senses, 5));
            Playground.addRessource(new Food(new Position2D(Math.random()*300 + 100, Math.random()*300 + 100), (int)(Math.random()*10)));
        }

        Playground.start();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Flat2DFrame ex = new Flat2DFrame();
                ex.setVisible(true);
            }
        });

    }
}
