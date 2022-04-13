package it.rrcompany.turingmachine.GUI.Input;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;
import it.rrcompany.turingmachine.TuringMachine;

import javax.swing.*;
import java.awt.*;

public class SpeedSelector extends JComboBox<String> implements TuringComponent {

    private static InputPanel parentPanel;
    public final static float scaleWidth = (float) 0.7/3;
    public final static float scaleHeight = (float) 0.09;

    public SpeedSelector(InputPanel parentPanel) {
        super(new String[]{
                "Speed x1",
                "Speed x2",
                "Speed x3",
                "Speed x4",
                "Speed x5",
                "Speed x6",
                "Speed x7",
                "Speed x8",
                "Speed x9",
                "Speed x10"});
        SpeedSelector.parentPanel = parentPanel;

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.GRAY);

        parentPanel.add(this);
        this.setVisible(true);

        this.setSelectedItem("Speed x5");
        TuringMachine.executor.setSpeed(5);

        this.resize();
    }

    @Override
    public void resize() {
        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14+(MainFrame.mainFrame.getHeight()-400)/100));

        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
    }

    public int getPosX() {
        return (int)(parentPanel.getWidth()*((1-InputField.scaleWidth)/2)+2*getWidth());
    }

    public int getPosY() {
        return (int)(parentPanel.getHeight()*(InputField.locHeight+InputField.scaleHeight));
    }

    public int getWidth() {
        return (int)(parentPanel.getWidth()*(scaleWidth));
    }

    public int getHeight() {
        return (int)(parentPanel.getHeight()*(scaleHeight));
    }

}
