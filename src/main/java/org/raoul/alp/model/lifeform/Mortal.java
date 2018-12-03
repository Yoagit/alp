package org.raoul.alp.model.lifeform;

import org.raoul.alp.model.position.Position;

public class Mortal extends Lifeform {

    public Mortal(int health, Position position, String name) {
        super(health, position, name);
    }

    public Mortal(int health, Position position) {
        super(health, position, "Mortal");
    }

    @Override
    public void lifeCycle() {
        this.older();
        this.decay();
    }

    @Override
    public void mitosis() {
        //No mitosis
    }

}
