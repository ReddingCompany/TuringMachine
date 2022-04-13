package it.rrcompany.turingmachine.GUI.Input;

import it.rrcompany.turingmachine.GUI.MainFrame;

import javax.swing.*;
import java.awt.*;

public class InputField extends JTextField {

    private static InputPanel parentPanel;
    public final static float scaleWidth = (float) 0.7;
    public final static float scaleHeight = (float) 0.09;
    public final static float locHeight = (float) 0.1;

    public InputField(InputPanel parentPanel) {
        InputField.parentPanel = parentPanel;

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        parentPanel.add(this);
        this.setVisible(true);

        this.setLocation((int)(parentPanel.getWidth()*((1-scaleWidth)/2)), (int)(parentPanel.getHeight()*(locHeight)));
        this.setSize((int)(parentPanel.getWidth()*InputField.scaleWidth), (int)(parentPanel.getHeight()*(scaleHeight)));

        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14+(MainFrame.mainFrame.getHeight()-400)/100));
    }

    public void resize() {

        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14+(MainFrame.mainFrame.getHeight()-400)/100));
        this.setLocation((int)(parentPanel.getWidth()*((1-scaleWidth)/2)), (int)(parentPanel.getHeight()*(locHeight)));
        this.setSize((int)(parentPanel.getWidth()*InputField.scaleWidth), (int)(parentPanel.getHeight()*(scaleHeight)));
    }


}

