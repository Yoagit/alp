package org.raoul.alp.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

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

        setTitle("Artificial Life playground.");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
