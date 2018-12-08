package org.raoul.alp.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.space.Space2D;

public class Flat2DFrame extends JFrame {
    
    public Flat2DFrame() {

        initUI();
    }

    private void initUI() {

        final Flat2D flat2D = new Flat2D();
        add(flat2D);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = flat2D.getTimer();
                timer.stop();
            }
        });

        this.setTitle("Artificial Life playground.");
        this.setSize(((Space2D)Playground.getSpace()).getWidth()+16, ((Space2D)Playground.getSpace()).getHeight()+38);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
