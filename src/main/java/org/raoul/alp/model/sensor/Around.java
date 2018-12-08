package org.raoul.alp.model.sensor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.position.Position;

public class Around extends Sens {
    
    private double radius;

    public Around(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Map<Double, Ressource> ressourceDetected(Position<Position<?>> position) {
        Map<Double, Ressource> result = new HashMap<>();
        Set<Ressource> objectOnGround = Playground.getOnGround();
        for (Ressource r : objectOnGround) {
            Double dist = position.distanceTo(r.getPosition()); 
            if (dist < this.radius) {
                result.put(dist, r);
            }
        }
        return result;
    }
    
    public Map<Double, Food> foodDetected(Position<Position<?>> position) {
        Map<Double, Food> result = new HashMap<>();
        Set<Ressource> objectOnGround = Playground.getOnGround();
        for (Ressource r : objectOnGround) {
            if (r instanceof Food){
            Double dist = position.distanceTo(r.getPosition()); 
            if (dist < this.radius) {
                result.put(dist, (Food)r);
            }}
        }
        return result;
    }
}
