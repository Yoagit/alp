package org.raoul.alp.model.space;

import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.PositionOriented;

public interface Space {
    Position<?> getRandomPosition();
    
    PositionOriented<?> getRandomOrientedPosition();

}
