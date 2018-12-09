package org.raoul.alp.view.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.sensor.Around;
import org.raoul.alp.model.sensor.Sens;
import org.raoul.alp.model.sensor.Vision;
import org.raoul.alp.model.space.position.Position;
import org.raoul.alp.model.space.position.Position2D;
import org.raoul.alp.model.space.position.Position2DOriented;

public class LifeformRepresentation implements Representation<Graphics2D, Lifeform> {

    private static LifeformRepresentation INSTANCE = new LifeformRepresentation();

    private LifeformRepresentation() {

    }

    public static LifeformRepresentation getInstance() {
        return INSTANCE;
    }

    @Override
    public void draw(Graphics2D g2d, Lifeform lf) {
        int age = lf.getAge();
        if (age > 255){
            age = 255;
        }
        if (lf.getHealth() > 0) {
            g2d.setPaint(new Color(age, age, 255));
        } else {
            g2d.setPaint(Color.red);
        }
        Position2D p2d = lf.getPosition().get2DPosition();
        g2d.fillOval((int) p2d.getX(), (int) p2d.getY(), 5, 5);

        g2d.setPaint(new Color(255, 175, 175, 127));
        Set<Sens<Position<?>>> senses = ((Sensed) lf).getSenses();
        for (Sens s : senses) {
            if (s instanceof Around) {
                int radius = (int) ((Around) s).getRadius();
                g2d.drawOval((int) p2d.getX() - radius, (int) p2d.getY() - radius, radius * 2, radius * 2);
            } else {
                if (s instanceof Vision){
                    double visionAngle = ((Vision) s).getVisionAngle();
                    double angle = ((Position2DOriented)lf.getPosition().get2DPosition()).getAngle();
                    g2d.drawLine((int) p2d.getX(), (int) p2d.getY(), (int) (p2d.getX() + 100*Math.cos(angle)), (int) (p2d.getY() + 100*Math.sin(angle)));
//                    g2d.drawLine((int) p2d.getX(), (int) p2d.getY(), (int) (p2d.getX() + 100*Math.cos(angle - visionAngle/2)), (int) (p2d.getY() + 100*Math.sin(angle - visionAngle/2)));
//                    g2d.drawLine((int) p2d.getX(), (int) p2d.getY(), (int) (p2d.getX() + 100*Math.cos(angle + visionAngle/2)), (int) (p2d.getY() + 100*Math.sin(angle + visionAngle/2)));
//                    g2d.drawArc((int) p2d.getX(), (int) p2d.getY(), 100, 100, (int)(180*angle/Math.PI), (int)(180*visionAngle/Math.PI));
//                    g2d.drawOval((int) p2d.getX() - radius, (int) p2d.getY() - radius, radius * 2, radius * 2);
                }
            }
        }
    }

}
