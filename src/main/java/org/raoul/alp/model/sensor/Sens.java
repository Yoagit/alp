package org.raoul.alp.model.sensor;

import java.util.Map;

import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.position.Position;

public interface Sens <T extends Position<?>>{

    public abstract Map<Double, Ressource> ressourceDetected(T position);

    public abstract Map<Double, Food> foodDetected(T position);
}
