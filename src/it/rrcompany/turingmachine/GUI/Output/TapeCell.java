package it.rrcompany.turingmachine.GUI.Output;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;

import javax.swing.*;
import java.awt.*;

public class TapeCell extends JLabel implements TuringComponent {

    private static OutputPanel parentPanel;
    public final static float scaleWidth = (float) 0.01915;
    public final static float scaleHeight = (float) 0.05;
    public final static float locHeight = (float) 0.7;
    public final static float locWidth = (float) 0.2;

    private JPanel backgroundPanel;
    private float index;

    public TapeCell(OutputPanel parentPanel, int index) {
        TapeCell.parentPanel = parentPanel;

        this.setFocusable(true);
        this.setLayout(null);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.WHITE);
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.backgroundPanel = backgroundPanel;

        parentPanel.add(this);
        parentPanel.add(backgroundPanel);
        this.setVisible(true);

        this.index = index;
        this.resize();
    }

    @Override
    public void resize() {
        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 9+(MainFrame.mainFrame.getHeight()-400)/100));

        backgroundPanel.setLocation(this.getPosX(), this.getPosY());
        backgroundPanel.setSize(this.getWidth(), this.getHeight());
        this.setLocation(this.getPosX()+(this.getWidth()/5), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
    }

    public int getPosX() {
        return (int)(parentPanel.getWidth()*(locWidth)+index*getWidth());
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

    public float getIndex() {
        return index;
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }
}
