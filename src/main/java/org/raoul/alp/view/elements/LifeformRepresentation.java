package org.raoul.alp.view.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.sensor.Around;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.model.space.position.Position2D;

public class LifeformRepresentation implements Representation<Graphics2D, Lifeform> {
    
    private static LifeformRepresentation INSTANCE = new LifeformRepresentation();
    
    private LifeformRepresentation(){
        
    }
    
    public static LifeformRepresentation getInstance(){
        return INSTANCE;
    }
    
    @Override
    public void draw(Graphics2D g2d, Lifeform lf){
        if (lf.getHealth() > 0) {
            g2d.setPaint(Color.blue);
        } else {
            g2d.setPaint(Color.red);
        }
        Position2D p2d = lf.getPosition().get2DPosition();
        g2d.fillOval((int) p2d.getX(), (int) p2d.getY(), 10, 10);

        g2d.setPaint(new Color(255, 175, 175, 127));
        Set<Sens> senses = ((Sensed)lf).getSenses();
        for (Sens s : senses){
            int radius = (int)((Around)s).getRadius();
            g2d.drawOval((int) p2d.getX()-radius, (int) p2d.getY()-radius, radius*2, radius*2);
        }
    }

}
