package org.raoul.alp.model.lifeform;

import org.raoul.alp.model.position.Position;

public class Immortal extends Lifeform {

    public Immortal(int health, Position position) {
        super(health, position, "Immortal");
    }

    @Override
    public void lifeCycle() {
        this.older();
    }

    @Override
    public void mitosis() {
        //No mitosis
    }

}
