package it.rrcompany.turingmachine.GUI.Output;

import it.rrcompany.turingmachine.GUI.Code.CodePanel;
import it.rrcompany.turingmachine.GUI.Input.InputPanel;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    private static JFrame parentFrame;

    public OutputPanel(JFrame parentFrame) {
        OutputPanel.parentFrame = parentFrame;

        this.setLocation(0, 0);
        this.setSize(parentFrame.getWidth()-((int)(parentFrame.getWidth()* CodePanel.scaleWidth)), (int)(parentFrame.getHeight()*(1- InputPanel.scaleHeight)));
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.BLUE);

        parentFrame.getContentPane().add(this);
        this.setVisible(true);
    }

    public void resize() {
        this.setLocation(0, 0);
        this.setSize(parentFrame.getWidth()-((int)(parentFrame.getWidth()*CodePanel.scaleWidth)), (int)(parentFrame.getHeight()*(1-InputPanel.scaleHeight)));
    }


}
