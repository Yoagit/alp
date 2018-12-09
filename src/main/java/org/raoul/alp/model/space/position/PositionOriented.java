package org.raoul.alp.model.space.position;

public interface PositionOriented <T extends Position<?>> extends Position<T> {
    double anglevariation(T position);
}
