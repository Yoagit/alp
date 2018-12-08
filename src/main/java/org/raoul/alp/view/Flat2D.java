package org.raoul.alp.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.lifeform.Sensed;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.Space2D;
import org.raoul.alp.model.space.position.Position2D;
import org.raoul.alp.view.elements.LifeformRepresentation;
import org.raoul.alp.view.elements.RessourceRepresentation;

public class Flat2D extends JPanel implements ActionListener {

    private final int DELAY = 10;
    private Timer timer;
    LifeformRepresentation lfr = LifeformRepresentation.getInstance();
    RessourceRepresentation resrep = RessourceRepresentation.getInstance();

    public Flat2D() {
        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {
        return timer;
    }

    private void doDrawing(Graphics g) {
        Set<Lifeform> lfs = Playground.getAlive();
        Set<Ressource> onGround = Playground.getOnGround();
        double speed = 0;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        g2d.fillRect(0, 0, ((Space2D)Playground.getSpace()).getWidth(), ((Space2D)Playground.getSpace()).getHeight());

        g2d.setPaint(Color.green);
        for (Ressource res : onGround) {
            resrep.draw(g2d, res);
        }

        for (Lifeform lf : lfs) {
            lfr.draw(g2d, lf);
            speed += ((Sensed)lf).getSpeed();
        }
        
        g2d.setPaint(Color.white);
        g2d.drawString("life from: " + lfs.size(), 0, 20);
        g2d.drawString("ressources: " + onGround.size(), 0, 40);
        g2d.drawString("Total: " + (lfs.size() + onGround.size()), 0, 60);
        g2d.drawString("Average speed: " + (speed/lfs.size()), 0, 80);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
