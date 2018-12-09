package org.raoul.alp;

import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.sensor.Around;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.model.sensor.Vision;
import org.raoul.alp.model.space.Space2D;
import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.Position2D;
import org.raoul.alp.model.space.position.Position2DOriented;
import org.raoul.alp.view.Flat2DFrame;

public class Application {
    public static void main(String[] args) {

        Set<Sens<Position<?>>> senses10 = new HashSet<>();
        senses10.add(new Around(20));
        Set<Sens<Position<?>>> senses50 = new HashSet<>();
        senses50.add(new Around(50));
        Set<Sens<Position<?>>> senses100 = new HashSet<>();
        senses100.add(new Around(100));
        Set<Sens<Position<?>>> senses200 = new HashSet<>();
        senses200.add(new Around(200));
        Set<Sens<Position<?>>> senses500 = new HashSet<>();
        senses500.add(new Around(500));
        Set<Sens<Position<?>>> vision = new HashSet<>();
        vision.add(new Vision(Math.PI));
        vision.add(new Around(50));
        Space2D space = new Space2D();
        Playground.setSpace(space);
        
        for(int i = 0; i < 500; i++){
            Playground.addRessource(new Food(Playground.getRandomPosition(), 5));
        }
        for(int i = 0; i < 10; i++){
            Playground.addLifeform(new Sensed(100, Playground.getRandomPosition(), senses10, 1));
            Playground.addLifeform(new Sensed(100, Playground.getRandomPosition(), senses50, 1));
//            Playground.addLifeform(new Sensed(100, Playground.getRandomPosition(), senses100, 1));
//            Playground.addLifeform(new Sensed(100, Playground.getRandomPosition(), senses200, 1));
//            Playground.addLifeform(new Sensed(100, Playground.getRandomPosition(), senses500, 1));
            Playground.addLifeform(new Sensed(100, Playground.getRandomOrientedPosition(), vision, 1));
            Playground.addLifeform(new Sensed(100, Playground.getRandomOrientedPosition(), vision, 1));
            Playground.addLifeform(new Sensed(100, Playground.getRandomOrientedPosition(), vision, 1));
        }
//        Playground.addLifeform(new Sensed(100, new Position2DOriented(200, 200, space, -Math.PI/2), vision, 1));

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Flat2DFrame ex = new Flat2DFrame();
                ex.setVisible(true);
            }
        });

    }
}
