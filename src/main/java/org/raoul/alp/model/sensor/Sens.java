package org.raoul.alp.model.sensor;

import java.util.Map;

import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.position.Position;

public abstract class Sens {

    public Sens() {
        super();
    }

    public abstract Map<Double, Ressource> ressourceDetected(Position<Position<?>> position);

    public abstract Map<Double, Food> foodDetected(Position<Position<?>> position);
}
