package org.raoul.alp.model.space;

import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.Position2D;
import org.raoul.alp.model.space.position.Position2DOriented;
import org.raoul.alp.model.space.position.PositionOriented;

public class Space2D implements Space {

    public final static int DEFAULT_WIDTH = 1600;
    public final static int DEFAULT_HEIGHT = 900;

    private int width;

    private int height;

    public Space2D(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Space2D() {
        super();
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Position<?> getRandomPosition() {
        return new Position2D(Math.random() * width, Math.random() * height, this);
    }
    public PositionOriented<?> getRandomOrientedPosition() {
        return new Position2DOriented(Math.random() * width, Math.random() * height, this);
    }
}
