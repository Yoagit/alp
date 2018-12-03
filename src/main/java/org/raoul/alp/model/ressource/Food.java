package org.raoul.alp.model.ressource;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.position.Position;

public class Food extends Ressource{
    private int energy;

    public Food(Position<?> position, int energy) {
        super(position);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
    
    public void consume(){
        this.energy--;
        if (this.energy < 1){
            Playground.removeRessource(this);
        }
    }
}
