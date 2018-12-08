package org.raoul.alp.model.ressource;

import org.raoul.alp.model.space.position.Position;

public class Ressource {
    private Position position;

    public Ressource(Position position) {
        super();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
