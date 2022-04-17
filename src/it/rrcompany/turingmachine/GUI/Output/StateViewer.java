package it.rrcompany.turingmachine.GUI.Output;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;
import it.rrcompany.turingmachine.TuringMachine;

import javax.swing.*;
import java.awt.*;

public class StateViewer extends JLabel implements TuringComponent {

    private static OutputPanel parentPanel;
    public final static float scaleWidth = (float) 0.01915*12;
    public final static float scaleHeight = (float) 0.3;
    public final static float locHeight = (float) 0.3;
    public final static float locWidth = (float) 0.3915;

    private JPanel backgroundPanel;

    public StateViewer(OutputPanel parentPanel) {
        StateViewer.parentPanel = parentPanel;

        this.setFocusable(true);
        this.setLayout(null);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.WHITE);
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.backgroundPanel = backgroundPanel;

        backgroundPanel.add(this);
        parentPanel.add(backgroundPanel);
        this.setVisible(true);

        this.resize();
    }

    @Override
    public void resize() {
        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 20+(MainFrame.mainFrame.getHeight()-400)/100));

        backgroundPanel.setLocation(this.getPosX(), this.getPosY());
        backgroundPanel.setSize(this.getWidth(), this.getHeight());
        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
    }

    public int getPosX() {
        return (int)(parentPanel.getWidth()*(locWidth));
    }

    public int getPosY() {
        return (int)(parentPanel.getHeight()*(locHeight));
    }

    public int getWidth() {
        return (int)(parentPanel.getWidth()*scaleWidth);
    }

    public int getHeight() {
        return (int)(parentPanel.getHeight()*(scaleHeight));
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }
}
