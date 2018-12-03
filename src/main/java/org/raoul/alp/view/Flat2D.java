package org.raoul.alp.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.position.Position2D;
import org.raoul.alp.model.ressource.Ressource;

public class Flat2D extends JPanel implements ActionListener {

    private final int DELAY = 10;
    private Timer timer;

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

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.green);
        for (Ressource lf : Playground.getOnGround()){
            Position2D p2d = lf.getPosition().get2DPosition();
            g2d.fillOval((int)p2d.getX(), (int)p2d.getY(), 7, 7);
        }

        for (Lifeform lf : Playground.getAlive()){
            if (lf.getHealth() > 0){
                g2d.setPaint(Color.blue);
            } else {
                g2d.setPaint(Color.red);
            }
            Position2D p2d = lf.getPosition().get2DPosition();
            g2d.fillOval((int)p2d.getX(), (int)p2d.getY(), 10, 10);
        }
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
