package org.raoul.alp.model.space;

import org.raoul.alp.model.space.position.Position;

public interface Space {
    Position<?> getRandomPosition();

}
