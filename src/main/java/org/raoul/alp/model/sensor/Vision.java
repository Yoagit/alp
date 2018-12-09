package org.raoul.alp.model.sensor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.PositionOriented;

public class Vision<T extends Position<?>> implements Sens<PositionOriented<T>> {

    double visionAngle;

    public Vision(double visionAngle) {
        super();
        this.visionAngle = visionAngle;
    }

    public double getVisionAngle() {
        return visionAngle;
    }

    @Override
    public Map<Double, Ressource> ressourceDetected(PositionOriented<T> position) {
        Map<Double, Ressource> result = new HashMap<>();
        Set<Ressource> objectOnGround = Playground.getOnGround();
        for (Ressource r : objectOnGround) {
            Double angle = position.anglevariation((T) r.getPosition());
            Double dist = position.distanceTo((T) r.getPosition());
            if (Math.abs(angle) < visionAngle / 2) {
                result.put(dist, r);
            }
        }
        return result;
    }

    @Override
    public Map<Double, Food> foodDetected(PositionOriented<T> position) {
        Map<Double, Food> result = new HashMap<>();
        Set<Ressource> objectOnGround = Playground.getOnGround();
        for (Ressource r : objectOnGround) {
            if (r instanceof Food) {
                Double angle = position.anglevariation((T) r.getPosition());
                Double dist = position.distanceTo((T) r.getPosition());
                if (Math.abs(angle) < visionAngle / 2) {
                    result.put(dist, (Food) r);
                }
            }
        }
        return result;
    }

}
