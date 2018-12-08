package org.raoul.alp.model.lifeform;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.Position2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sensed extends Mortal {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sensed.class);

    Set<Sens> senses;
    double speed;

    public double getSpeed() {
        return speed;
    }

    public Set<Sens> getSenses() {
        return senses;
    }

    public Sensed(int health, Position position, Set<Sens> senses, double speed) {
        super(health, position, "Sensed");
        this.senses = senses;
        this.speed = speed;
    }

    @Override
    public void lifeCycle() {
        this.older();
        this.decay();

        if (this.isHealNeeded()) {
            Map<Double, Food> detectedRessource = new HashMap<>();
            for (Sens s : this.senses) {
                detectedRessource.putAll(s.foodDetected(this.getPosition()));
            }
            if (!detectedRessource.isEmpty()) {
                Double closest = Double.MAX_VALUE;
                for (Double dist : detectedRessource.keySet()) {
                    closest = Math.min(closest, dist);
                }
                Food targetRessource = detectedRessource.get(closest);

                if (closest == 0) {
                    // eat it.
                    // LOGGER.info("Eating stuff");
                    if (targetRessource.getEnergy() > 0) {
                        targetRessource.consume();
                        this.heal();
                    }
                } else {
                    // move to it.
                    // LOGGER.info("Moving from " + this.getPosition() + " / to:
                    // " + targetRessource.getPosition().toString());
                    this.getPosition().moveTo(targetRessource.getPosition(), this.speed);
                    this.decay((int) this.speed);
                    // LOGGER.info("After Move " + this.getPosition());
                }
            } else {
                // LOGGER.info("Can't see any ressource.");
                this.getPosition().randomMove(this.speed);
                this.decay((int) this.speed);
            }
        } else {
            this.getPosition().randomMove(this.speed);
            this.decay((int) this.speed);
        }
    }

    @Override
    public void mitosis() {
        Playground.addLifeform(
                new Sensed(100, this.getPosition().duplicate(), this.senses, this.speed + (Math.random()) - 0.5));
    }
}
