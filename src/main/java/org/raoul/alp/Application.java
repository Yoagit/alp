package org.raoul.alp;

import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.sensor.Around;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.model.space.Space2D;
import org.raoul.alp.model.space.position.Position2D;
import org.raoul.alp.view.Flat2DFrame;

public class Application {
    public static void main(String[] args) {

        Set<Sens> senses10 = new HashSet<>();
        senses10.add(new Around(10));
        Set<Sens> senses50 = new HashSet<>();
        senses50.add(new Around(50));
        Set<Sens> senses100 = new HashSet<>();
        senses100.add(new Around(100));
        Set<Sens> senses200 = new HashSet<>();
        senses200.add(new Around(200));
        Set<Sens> senses500 = new HashSet<>();
        senses500.add(new Around(500));
        Playground.setSpace(new Space2D());
        
        for(int i = 0; i < 100; i++){
            Playground.addRessource(new Food(Playground.getRandomPosition(), 5));
        }
        for(int i = 0; i < 10; i++){
            Playground.addLifeform(new Sensed(200, Playground.getRandomPosition(), senses10, 1));
            Playground.addLifeform(new Sensed(200, Playground.getRandomPosition(), senses50, 1));
            Playground.addLifeform(new Sensed(200, Playground.getRandomPosition(), senses100, 1));
            Playground.addLifeform(new Sensed(200, Playground.getRandomPosition(), senses200, 1));
            Playground.addLifeform(new Sensed(200, Playground.getRandomPosition(), senses500, 1));
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Flat2DFrame ex = new Flat2DFrame();
                ex.setVisible(true);
            }
        });

    }
}
