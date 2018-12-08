package org.raoul.alp.view.elements;

import java.awt.Graphics;

import org.raoul.alp.model.lifeform.Lifeform;

public interface Representation <T extends Graphics, L extends Object> {
    void draw(T g, L lf);
}
