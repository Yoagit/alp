package org.raoul.alp.model.position;

public interface Position<T extends Position<?>> {

    double distanceTo(T p);

    void moveTo(T position, double distance);

    void randomMove(double distance);

    Position2D get2DPosition();
}
