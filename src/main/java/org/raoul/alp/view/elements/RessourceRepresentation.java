package org.raoul.alp.view.elements;

import java.awt.Graphics2D;

import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.position.Position2D;

public class RessourceRepresentation  implements Representation<Graphics2D, Ressource> {

    private static RessourceRepresentation INSTANCE = new RessourceRepresentation();
    private RessourceRepresentation(){
        
    }
    
    public static RessourceRepresentation getInstance(){
        return INSTANCE;
    }
    
    @Override
    public void draw(Graphics2D g2d, Ressource res) {
        Position2D p2d = res.getPosition().get2DPosition();
        g2d.fillOval((int) p2d.getX(), (int) p2d.getY(), 7, 7);
    }

}
